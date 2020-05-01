_layer = 85125; 

while {true} do 
{ 
	if (currentVisionMode player == 2) then	
	{
			if (alive (getConnectedUAV player)) then		
				{																											
					_layer    cutText ["Leider ist das Infrarotsichtgerät defekt. Nutze die Normale oder die restlichtverstärkende Ansicht.","BLACK",-1];	
					waituntil {currentVisionMode player != 2};
					_layer cutText ["", "PLAIN"];
				}
			else
				{
					setViewDistance 1250;																			
					waituntil {currentVisionMode player != 2};
					setViewDistance -1;
				}
	};	
sleep 1;
};