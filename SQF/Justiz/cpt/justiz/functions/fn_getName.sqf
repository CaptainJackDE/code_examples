if !(playerSide isEqualTo east) exitWith {};
if((call life_laclevel) < getNumber(missionConfigFile >> "cpt_justiz" >> "min_level_number")) exitWith {["Achtung","Du bist nicht für diese Aktion autorisiert!", "error"] spawn cplus_notification_fnc_notification;};
private["_number"];

_number = ctrlText 19001;

sleep (random [5,15,25]);

if ([_number] call TON_fnc_isnumber) then {
	_return = [3,_number] remoteExec ["cpt_fnc_justiz",2];
	["Ergebnis",format["Der Besitzer der Telefonnummer ist: %1",_return],"success"] spawn cplus_notification_fnc_notification;
} else {
	["Achtung","Es konnte kein Ergebnis ermittelt werden!", "error"] spawn cplus_notification_fnc_notification;
};