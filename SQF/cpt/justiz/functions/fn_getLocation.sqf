if !(playerSide isEqualTo east) exitWith {};
if((call life_laclevel) < getNumber(missionConfigFile >> "cpt_justiz" >> "min_level_locator")) exitWith {["Achtung","Du bist nicht für diese Aktion autorisiert!", "error"] spawn cplus_notification_fnc_notification;};
private ["_number","_playerTo"];

_number = ctrlText 19001;
if !([_number] call TON_fnc_isnumber) exitWith {["Fehler!","Dies ist keine Telefonnummer!","error"] spawn cplus_notification_fnc_notification;};
if(_number isEqualTo (player getVariable ["maxence_numero",""])) exitWith {["Fehler!","Du kannst dich nicht selbst orten!","error"] spawn cplus_notification_fnc_notification;};
sleep (random [5,15,25]);

_fn_findPlayerNumber = {
    {
        _num = _x getVariable "maxence_numero";
        if (_this isEqualTo _num) exitWith {_x;};
         objNull
    } foreach playableUnits;
};
_playerTo = _number call _fn_findPlayerNumber;

if (('Mattaust_Phone' in assignedItems _playerTo) || !(isNull _playerTo)) then {
    ["Ortungsergebnis",format["Die Person wurde an folgender Position geortet:<br /><t align='center'>%1</t><br /><br /><t align='center' size=2>%2</t>",name _playerTo, mapGridPosition _playerTo], "success"] spawn cplus_notification_fnc_notification;
} else {
    ["Fehler!","Das Telefon ist nicht eingeschaltet oder die Nummer ist nicht erreichbar.","error"] spawn cplus_notification_fnc_notification;
};