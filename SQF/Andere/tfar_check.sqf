waitUntil { !isNull player };
waitUntil { uiSleep 2; (!isNull (findDisplay 46)) };

ftfar_server_name = getText (missionConfigFile >> "ForceTFAR" >> "ftfar_server_name");
ftfar_server_ipaddress = getText (missionConfigFile >> "ForceTFAR" >> "ftfar_server_ipaddress");
ftfar_wait_for_action_time = getNumber (missionConfigFile >> "ForceTFAR" >> "ftfar_wait_for_action_time");
ftfar_radio_channel_password = getText (missionConfigFile >> "ForceTFAR" >> "ftfar_radio_channel_password");
ftfar_radio_channel_name = getArray (missionConfigFile >> "ForceTFAR" >> "ftfar_radio_channel_name");
ftfar_support_timer = getNumber (missionConfigFile >> "ForceTFAR" >> "ftfar_support_timer");
if (getPlayerUID player in (getArray (missionConfigFile >> "ForceTFAR" >> "ftfar_uids"))) exitwith { true };
private _tfarchannel = ftfar_radio_channel_name select 0;

if (!(isNil "life_adminlevel")) then {
	private _adminlvl = life_adminlevel call BIS_fnc_parseNumber;
	if (_adminlvl >= 1) then {
		_isadmin = true;
		_timer = ftfar_support_timer;
	};
};

if !(isClass (configFile >> "CfgPatches" >> "task_force_radio")) exitWith
{
	[] spawn
	{
		private _message = "Dein TFAR ist nicht aktiviert.\nAktiviere bitte TFAR.";
		private _timer = ftfar_wait_for_action_time;
		while {_timer > 0} do {
			cutText [format["%1\n%2", _message, format["Du wirst in %1 Sekunden in die Lobby zurückkehren.", _timer]], "BLACK FADED", 999];
			uiSleep 1;
			_timer = _timer - 1;
		};
		(findDisplay 46) closeDisplay 0;
		true
	};
};


TFS_fnc_ftfar_checkTeamSpeakServer = {
	private _currentServerName = call TFAR_fnc_getTeamSpeakServerName;
	if (_currentServerName isEqualTo ftfar_server_name) exitWith { true };
	false
};

TFS_fnc_ftfar_getWrongServerString = {format["Du bist nicht auf dem richtigen TeamSpeak: %1!\nBitte gehe auf %2!", ftfar_server_name, ftfar_server_ipaddress];};

TFS_fnc_ftfar_checkTeamSpeakChannel = {
	private _currentChannelName = call TFAR_fnc_getTeamSpeakChannelName;
	if (_currentChannelName in ftfar_radio_channel_name) exitWith { true };
	false
};
TFS_fnc_ftfar_getWrongChannelString ={format["Du bist im falschen TeamSpeak-Channel!\nBitte gehe in %1 zurück!", _tfarchannel];};
FTFAR_waitForActionThread = nil;

while {true} do {
	if (isNil "FTFAR_waitForActionThread") then {
		try {
			if !(call TFAR_fnc_isTeamSpeakPluginEnabled) throw ["TFAR ist nicht aktiviert!\nBitte aktiviere es in deinen Einstellungen.", TFAR_fnc_isTeamSpeakPluginEnabled];
			if !(call TFS_fnc_ftfar_checkTeamSpeakServer) throw [call TFS_fnc_ftfar_getWrongServerString, TFS_fnc_ftfar_checkTeamSpeakServer];
			if !(call TFS_fnc_ftfar_checkTeamSpeakChannel) throw [call TFS_fnc_ftfar_getWrongChannelString, TFS_fnc_ftfar_checkTeamSpeakChannel];
		} catch {
			FTFAR_waitForActionThread = _exception spawn {
				params [["_message", ""],["_checkFunction", ""]];
				private _timer = ftfar_wait_for_action_time;
				if (!(isNil "life_adminlevel")) then {
					private _adminlvl = life_adminlevel call BIS_fnc_parseNumber;
					if (_adminlvl >= 1) then {
						_isadmin = true;
						_timer = ftfar_support_timer;
					};
				};

				while {_timer > 0} do {
					cutText [format["%1\n%2", _message, format["Du hast noch %1 Sekunden.", _timer]], "BLACK FADED", 999];
					uiSleep 1;
					_timer = _timer - 1;
					if (call _checkFunction) exitWith {};
				};

				if ((call TFS_fnc_ftfar_checkTeamSpeakServer) || (call TFS_fnc_ftfar_checkTeamSpeakChannel)) exitWith {
					cutText ["", "BLACK IN", 2];
					FTFAR_waitForActionThread = nil;
				};

				(findDisplay 46) closeDisplay 0;
				true
			};
		};
	};
	uiSleep 0.01;
};
true