if !(playerSide isEqualTo east) exitWith {};
if((call life_laclevel) < getNumber(missionConfigFile >> "cpt_justiz" >> "min_level_unlock")) exitWith {["Achtung","Du bist nicht für diese Aktion autorisiert!", "error"] spawn cplus_notification_fnc_notification;};
private ["_number","_playerTo"];
_number = ctrlText 19001;

if!([_number] call TON_fnc_isnumber) exitWith {["Fehler!","Dies ist keine Telefonnummer!","error"] spawn cplus_notification_fnc_notification;};
if(_number isEqualTo (player getVariable ["maxence_numero",""])) exitWith {["Fehler!","Du kannst deine eigene SIM nicht entsperren!","error"] spawn cplus_notification_fnc_notification;};

_fn_findPlayerNumber = {
    {
        _num = _x getVariable "maxence_numero";
        if (_this isEqualTo _num) exitWith {_x;};
         objNull
    } foreach playableUnits;
};
_playerTo = _number call _fn_findPlayerNumber;

if (!(isNull _playerTo) && (_playerTo getVariable ["simlock",false])) then {
	_playerTo setVariable ["simlock", false, true];
};

[5,_number] remoteExec ["cpt_fnc_justiz",2];

["Erfolgreich","Die SIM-Karte wurde entsperrt.","success"] spawn cplus_notification_fnc_notification;
