_mode = param[0,0];
_tel = param[1, 0];
_pid = param [2,""];
_tables = ["idcard_data_civ","idcard_data_cop","idcard_data_med","idcard_data_lac"];

switch (_mode) do {
	case 1: {//getBank by number
		_query = format["SELECT bankacc FROM players WHERE phone_number LIKE '%1' LIMIT 1",_tel];
    	_return = [_query, 2] call DB_fnc_asyncCall;
	}; 
	case 2: {//getBank by name
		{
        	_query = format["SELECT bankacc FROM players WHERE %1 LIKE '%2' LIMIT 1",_x,_tel];
        	_queryResult = [_query, 2, true] call DB_fnc_asyncCall;
        	if ([_queryResult] call TON_fnc_isnumber) exitWith {_return = _queryResult;};
    	}forEach _tables;
	};
	case 3: {//getName
		_query = format["SELECT idcard_data_civ FROM players WHERE phone_number LIKE '%1' LIMIT 1",_tel];
    	_queryResult = [_query, 2] call DB_fnc_asyncCall;
		_return = _queryResult select 0;
	}; 
	case 4: {//lockPhone
		_query = format["UPDATE players SET simlock='1' WHERE phone_number LIKE '%1'",_tel];
		[_query, 1] call DB_fnc_asyncCall;
	}; 
	case 5: {//unlockPhone
		_query = format["UPDATE players SET simlock='0' WHERE phone_number LIKE '%1'",_tel];
		[_query, 1] call DB_fnc_asyncCall;
	}; 
	case 6 {
		_query = format["SELECT simlock FROM players WHERE pid LIKE '%2' LIMIT 1", _pid]; 
		_return= [_query, 2, true] call DB_fnc_asyncCall;
	};
};

_return;