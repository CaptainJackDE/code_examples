if !(playerSide isEqualTo east) exitWith {};
if((call life_laclevel) < getNumber(missionConfigFile >> "cpt_justiz" >> "min_level_lock")) exitWith {["Achtung","Du bist nicht für diese Aktion autorisiert!", "error"] spawn cplus_notification_fnc_notification;};
private ["_number","_playerTo"];
_number = ctrlText 19001;

if!([_number] call TON_fnc_isnumber) exitWith {["Fehler!","Dies ist keine gültige Telefonnummer!","error"] spawn cplus_notification_fnc_notification;};
if(_number isEqualTo (player getVariable ["maxence_numero",""])) exitWith {["Fehler!","Du kannst deine eigene SIM nicht sperren!","error"] spawn cplus_notification_fnc_notification;};

_fn_findPlayerNumber = {
    {
        _num = _x getVariable "maxence_numero";
        if (_this isEqualTo _num) exitWith {_x;};
         objNull
    } foreach playableUnits;
};
_playerTo = _number call _fn_findPlayerNumber;

if (!(isNull _playerTo) && !(_playerTo getVariable ["simlock",false])) then {
	_playerTo setVariable ["simlock", true, true];
};

if((_playerTo getVariable ["getCalls_17",false]) && (side _playerTo IsEqualTo west)) then {_playerTo setVariable ["getCalls_17",false,true];};
if((_playerTo getVariable ["getCalls_18",false]) && (side _playerTo IsEqualTo independent)) then {_playerTo setVariable ["getCalls_18",false,true];};
if(_playerTo getVariable ["getCalls_dep",false]) then {_playerTo setVariable ["getCalls_dep",false,true];};
if((_playerTo getVariable ["getCalls_east",false]) && (side _playerTo IsEqualTo east)) then {_playerTo setVariable ["getCalls_east",false,true];};
_class = _playerTo getVariable "current_entreprise";

if !(isNil _class) then {
    _num = getNumber(missionConfigFile >> "Max_Settings_Phone" >> "special_numbers" >> _class >> "number");
    _var = format["getCalls_%1",_num];
    _playerTo setVariable ["_var",false,true];
};

[4,_number] remoteExec ["cpt_fnc_justiz",2];

["Erfolgreich","Die SIM-Karte wurde gesperrt.","success"] spawn cplus_notification_fnc_notification;
