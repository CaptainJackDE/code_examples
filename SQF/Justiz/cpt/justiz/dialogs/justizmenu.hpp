/////////////////////////////////////////////////////////////////
/////////// This File was Edited by GUI D3V by Shinji ///////////
/////////////////////////////////////////////////////////////////
class justizmenu {
   idd = 20020;
   name = "justizmenu";
   movingenable = false;
   enablesimulation = true;
   class controlsBackground
   {
       class Life_RscTitleBackground : Life_RscText
       {
           colorbackground[] = {"(profilenamespace getvariable ['GUI_BCG_RGB_R',0.3843])", "(profilenamespace getvariable ['GUI_BCG_RGB_G',0.7019])", "(profilenamespace getvariable ['GUI_BCG_RGB_B',0.8862])", "(profilenamespace getvariable ['GUI_BCG_RGB_A',0.7])"};
           idc = -1;
           x = 0.3 * safezoneW + safezoneX;
           y = 0.2 * safezoneH + safezoneY;
           w = 0.47 * safezoneW;
           h = (1 / 25) * safezoneH;
       };
       class MainBackground : Life_RscText
       {
           colorbackground[] = {0. 0. 0. 0.7};
           idc = -1;
           x = 0.3 * safezoneW + safezoneX;
           y = 0.2 + (11 / 250) * safezoneH + safezoneY;
           w = 0.47 * safezoneW;
           h = 0.3 - (22 / 250) * safezoneH;
       };
   };
   class controls
   {
       class Title : Life_RscTitle
       {
           colorbackground[] = {0. 0. 0. 0};
           idc = 2651;
           text = "Aktion auswählen";
           x = 0.3 * safezoneW + safezoneX;
           y = 0.2 * safezoneH + safezoneY;
           w = 0.47 * safezoneW;
           h = (1 / 25) * safezoneH;
       };
       class Bankabfrage : Life_RscButtonMenu
       {
           idc = 20002;
           text = "Bankabfrage";
           onbuttonclick = "closeDialog 0; createDialog ""getbank"";";
           x = 0.615 * safezoneW + safezoneX;
           y = 0.26 * safezoneH + safezoneY;
           w = 0.14 * safezoneW;
           h = 0.04 * safezoneH;
       };
       class Kennzeichen : Life_RscButtonMenu
       {
           idc = 20003;
           text = "Kennzeichen";
           onbuttonclick = "closeDialog 0; createDialog ""max_search_plate"";";
           x = 0.31 * safezoneW + safezoneX;
           y = 0.26 * safezoneH + safezoneY;
           w = 0.14 * safezoneW;
           h = 0.04 * safezoneH;
       };
       class closeDialog : Life_RscButtonMenu
       {
           idc = 20001;
           text = "Schließen";
           colorbackground[] = {"(profilenamespace getvariable ['GUI_BCG_RGB_R',0.3843])", "(profilenamespace getvariable ['GUI_BCG_RGB_G',0.7019])", "(profilenamespace getvariable ['GUI_BCG_RGB_B',0.8862])", 0.5};
           onbuttonclick = "closeDialog 0;";
           x = 0.66 * safezoneW + safezoneX;
           y = 0.4 * safezoneH + safezoneY;
           w = 0.1 * safezoneW;
           h = (1 / 25) * safezoneH;
       };
       class LocationTracking : Life_RscButtonMenu
       {
           idc = 20000;
           text = "Ortung";
           onbuttonclick = "closeDialog 0; createDialog ""locator"";";
           x = 0.463 * safezoneW + safezoneX;
           y = 0.26 * safezoneH + safezoneY;
           w = 0.14 * safezoneW;
           h = (1 / 25) * safezoneH;
       };
       class Telefonnummer : Life_RscButtonMenu
       {
           idc = 20004;
           text = "Nummernabfrage";
           onbuttonclick = "closeDialog 0; createDialog ""number"";";
           x = 0.31 * safezoneW + safezoneX;
           y = 0.31 * safezoneH + safezoneY;
           w = 0.14 * safezoneW;
           h = 0.04 * safezoneH;
       };
       class SOS : Life_RscButtonMenu
       {
           idc = 20005;
           text = "SIM-Entsperrung";
           onbuttonclick = "closeDialog 0; createDialog ""unlockphone"";";
           x = 0.615 * safezoneW + safezoneX;
           y = 0.31 * safezoneH + safezoneY;
           w = 0.14 * safezoneW;
           h = 0.04 * safezoneH;
       };
       class Telefonsperrung : Life_RscButtonMenu
       {
           idc = 20006;
           text = "SIM-Sperrung";
           onbuttonclick = "closeDialog 0; createDialog ""lockphone"";";
           x = 0.463 * safezoneW + safezoneX;
           y = 0.31 * safezoneH + safezoneY;
           w = 0.14 * safezoneW;
           h = 0.04 * safezoneH;
       };
       class Interpol : Life_RscButtonMenu
       {
           idc = 20007;
           text = "Interpol";
           onbuttonclick = "closeDialog 0; [0] remoteExec [""max_interpol_fnc_getInterpol"",2];";
           x = 0.31 * safezoneW + safezoneX;
           y = 0.36 * safezoneH + safezoneY;
           w = 0.14 * safezoneW;
           h = 0.04 * safezoneH;
       };
       class Rechnung : Life_RscButtonMenu
       {
           idc = 20008;
           text = "Rechnung";
           onbuttonclick = "closeDialog 0; createDialog ""facture_list"";";
           x = 0.463 * safezoneW + safezoneX;
           y = 0.36 * safezoneH + safezoneY;
           w = 0.14 * safezoneW;
           h = 0.04 * safezoneH;
       };
   };
};
/////////////////////////////////////////////////////////////////
////////////////////////// FILE END /////////////////////////////
/////////////////////////////////////////////////////////////////
