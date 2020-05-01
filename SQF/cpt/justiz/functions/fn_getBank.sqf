if !(playerSide isEqualTo east) exitWith {};
if((call life_laclevel) < getNumber(missionConfigFile >> "cpt_justiz" >> "min_level_bank")) exitWith {["Achtung","Du bist nicht für diese Aktion autorisiert!", "error"] spawn cplus_notification_fnc_notification;};
private["_number","_tables"];
_tables = ["idcard_data_civ","idcard_data_cop","idcard_data_med","idcard_data_lac"];

_number = ctrlText 19001;

if ([_number] call TON_fnc_isnumber) then {
    _return = [1,_number] remoteExec ["cpt_fnc_justiz",2];
} else {
    _return = [2,_number] remoteExec ["cpt_fnc_justiz",2];
};

sleep (random [5,15,25]);

if !([_return] call TON_fnc_isnumber) then {
    ["Achtung","Es konnte kein Ergebnis ermittelt werden!", "error"] spawn cplus_notification_fnc_notification;
} else {
    ["Ergebnis",format["Der Kontostand beträgt %1$",_return],"success"] spawn cplus_notification_fnc_notification;
};