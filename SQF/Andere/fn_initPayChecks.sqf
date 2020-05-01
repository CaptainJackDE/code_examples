#include "..\..\script_macros.hpp"
private ["_time","_rank","_gehalt","_department","_gehaltfinal","_color","_tax","_shutdown1","_shutdown2","_shutdown3","_apf","_doj","_amr","_ziv","_kurz","_regierung","_notifshutdown1","_notifshutdown2","_array","_level"];

if(life_scott_paycheck) exitwith {};
_shutdown1 = 350000; //Shutdown Regierungskonto
_shutdown2 = 350000; //Shutdown AFP-Konto
_shutdown3 = 350000; //SHutdown AMR-Konto
_time = 10; // Zeit in Minuten

_afp = [[0,"AFP"],[650,"Recruit"],[700,"Officer"],[750,"Sergeant"],[800,"1st Sergeant"],[850,"Inspector"],[900,"Corporal"],[950,"Lieutenant"],[1000,"1st Lieutenant"],[1050,"Captain"],[1100,"Commander"],[1150,"Deputy Chief"],[1200,"Chief"],[1250,"Commissioner"]];
_doj = [[0,"DoJ"],[800,"Depuy Marshal"],[900,"Special Agent"],[1000,"Senior Special Agent"],[1100,"Executive of Training"],[1200,"Deputy Director"],[1300,"Director"],[800,"District Attorney"],[900,"Prosecutor"],[100,"Solicitor General"],[1100,"District Judge"],[1200,"Federal Judge"],[1300,"Chief Justice"],[1400,"Secretary General"],[1500,"Deputy Attorney General"],[1600,"Attorney General"]];
_amr = [[0,"AMR"],[650,"Trainee"],[700,"Emergency Responder"],[750,"Emergency Medic"],[800,"AE Meadic"],[850,"Paramedic"],[900,"Medical Psychologist"],[950,"Instructor"],[1000,"Leadung Instructor"],[1050,"Assistant Chief"],[1100,"Chief"],[1150,"Commissioner"]];
_ziv = [[100,"Bürger"],[0,"Regierung"],[1000,"Regierungssicherheit"],[1500,"Minister"],[2000,"Gouverneur"]];


while {true} do {
	_regierung = 0;
	if ([(name player),(getPlayerUID player)] in maxence_gouverneur) then {_regierung = 4;};
	if ([(name player),(getPlayerUID player)] in maxence_ministres) then {_regierung = 3;};
	if ([(name player),(getPlayerUID player)] in maxence_security) then {_regierung =  2;};
	life_scott_paycheck = true;
	sleep (_time*60);
	_tax = 0;
	_gehalt = 0;
	_rank="";
	_color = "#40FF00";
	_kurz = false;
	_notifshutdown1 = false;
	_notifshutdown2 = false;

	
	if (alive player) then {
		switch (playerSide) do {
			case west: {
				_level = call life_coplevel;
				_array = _afp;
				if(license_cop_gehaltcop) then {_kurz = true;};
			};
			case east: {			
				_level = call life_laclevel;
				_array = _doj;	
				if(license_lac_gehaltjustiz) then {_kurz = true;};
			};
			case independent: {			
				_level = call life_mediclevel;
				_array = _amr;
				if(license_med_gehaltmed) then {_kurz = true;};
			};
			default {
				_level = _regierung;
				_array = _ziv;
			};
		};
		if(_level > count _array) then {_level = count _array;};
		if(_level < 0) then {_level = 0;};

		_rank = _array select _level select 1;
		if ((playerSide isEqualTo CIVILIAN) && (_regierung > 0)) then {_gehalt = _ziv select _regierung select 0;};
		_gehalt = (_gehalt + (_array select _level select 0)) * (missionNamespace getVariable ["mav_ttm_var_paycheckMultiplier", 1]);
		if((_regierung isEqualTo 0) && (playerSide isEqualTo CIVILIAN)) then {_department = _ziv select 1 select 1;} else {_department = _array select 0 select 1;};
		if(_kurz) then {_gehalt = round (_gehalt / 2);};

		switch (playerSide) do {
			case west: {
				if(maxence_compte_cop < _shutdown2) then {
					if(maxence_compte_gouv < _shutdown1) then {
						_notifshutdown1 = true;
					} else {
						_notifshutdown2 = true;
						maxence_compte_gouv = maxence_compte_gouv - (_gehalt/2);
						publicVariable "maxence_compte_gouv";
					};
				} else {
					maxence_compte_cop = maxence_compte_cop - (_gehalt/2);
					publicVariable "maxence_compte_cop";
				};
			};
			case independent: {
				if(maxence_compte_med < _shutdown3) then {
					if(maxence_compte_gouv < _shutdown1) then {
						_notifshutdown1 = true;
					} else {
						_notifshutdown2 = true;
						maxence_compte_gouv = maxence_compte_gouv - (_gehalt/2);
						publicVariable "maxence_compte_gouv";
					};
				} else {
					maxence_compte_med = maxence_compte_med - (_gehalt/2);
					publicVariable "maxence_compte_med";
				};		
			};
			default {
				if(maxence_compte_gouv < _shutdown1) then {
						_notifshutdown1 = true;
				} else {
					maxence_compte_gouv = maxence_compte_gouv - (_gehalt/2);
					publicVariable "maxence_compte_gouv";
				};
			};
		};

		if ((!(PlayerSide isEqualTo civilian) || (_regierung > 0)) && !(_notifshutdown2)) then {
			_tax = round(((maxence_taxes select 2) / 100) * _gehalt);
			maxence_compte_gouv = maxence_compte_gouv + _tax;
			publicVariable "maxence_compte_gouv";
		};

		if(_notifshutdown1) then {["Achtung!","Die Haushaltskasse deiner Behörde ist aufgebraucht! Dein Geld wird nun von der Regierungskasse überwiesen.", "attention"] spawn cplus_notification_fnc_notification;};
		if(_notifshutdown2) then {
			["Achtung!","Derzeit besteht eine Haushaltssperre, du erhälst deshalb kein Geld vom Staat!", "attention"] spawn cplus_notification_fnc_notification;
			_gehalt = 0;
			_tax = 0;
		};

		_gehaltfinal = round(_gehalt - _tax);		
		
		if (BANK + _gehaltfinal <= 0) then {
			BANK = 0;
			_color = "#FF0000";
		} else {
			BANK = BANK + _gehaltfinal;
		};

		if ((!(PlayerSide isEqualTo civilian) || !(_regierung isEqualTo 0)) && ((_notifshutdown1 isEqualTo false) || (_notifshutdown2 isEqualTo false))) then {
			["Ihr Gehalt ist da!", format["<t align='center' size=2>Gehalt</t><br />  
  			-----------------------------------------------------<br />  
  			<t align='left'>Behörde:</t> <t align='right'>%1</t><br />  
  			<t align='left'>Rang:</t> <t align='right'>%2</t><br />  
  			<t align='left'>Grundgehalt:</t> <t align='right'>%3</t><br />  
  			-----------------------------------------------------<br />  
  			<a color='#FF0000'><t align='left'>Steuern (%4):</t> <t align='right'>%5</t></a><br />  
  			-----------------------------------------------------<br />  
  			<a color='%6'><t align='left'>Auszahlung:</t> <t align='right'>%7</t></a><br />", _department, _rank, _gehalt, maxence_taxes select 2, _tax, _color, _gehaltfinal], "event_msg"] spawn cplus_notification_fnc_notification;
		} else {
			["Sie erhalten Geld!",format["Sie haben ihr Grundeinkommen in Höhe von %1$ erhalten!",_gehalt], "event_msg"] spawn cplus_notification_fnc_notification;
		};
	} else {
		["Sie erhalten Geld!","Da du außer Gefecht warst, konnte dir dein Geld nicht ausgezahlt werden!", "event_msg"] spawn cplus_notification_fnc_notification;
	};
};