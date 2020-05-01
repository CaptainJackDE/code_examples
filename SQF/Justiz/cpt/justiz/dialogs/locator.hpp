class locator {
   idd = 18999;
   name = "locator";
   movingenable = false;
   enablesimulation = true;
   class controlsBackground
   {
       class Life_RscTitleBackground : Life_RscText
       {
           colorbackground[] = {"(profilenamespace getvariable ['GUI_BCG_RGB_R',0.3843])", "(profilenamespace getvariable ['GUI_BCG_RGB_G',0.7019])", "(profilenamespace getvariable ['GUI_BCG_RGB_B',0.8862])", "(profilenamespace getvariable ['GUI_BCG_RGB_A',0.7])"};
           idc = -1;
           x = 0.3;
           y = 0.2;
           w = 0.47;
           h = (1 / 25);
       };
       class MainBackground : Life_RscText
       {
           colorbackground[] = {0, 0, 0, 0.7};
           idc = -1;
           x = 0.3;
           y = 0.2 + (11 / 250);
           w = 0.47;
           h = 0.3 - (22 / 250);
       };
   };
   class controls
   {
       class Title : Life_RscTitle
       {
           colorbackground[] = {0, 0, 0, 0};
           idc = 19004;
           text = "Telefonortung";
           x = 0.3;
           y = 0.2;
           w = 0.6;
           h = (1 / 25);
       };
       class InfoMsg : Life_RscText
       {
           idc = 19003;
           text = "Telefonnummer:";
           x = 0.3;
           y = 0.163 + (11 / 250);
           w = 0.45;
           h = 0.12;
       };
       class textEdit : Life_RscEdit
       {
           idc = 19001;
           text = "";
           sizeex = 0.030;
           x = 0.40;
           y = 0.30;
           w = 0.25;
           h = 0.03;
       };
       class start_loc : Life_RscButtonMenu
       {
           idc = 19000;
           text = "Ortung starten";
           colorbackground[] = {"(profilenamespace getvariable ['GUI_BCG_RGB_R',0.3843])", "(profilenamespace getvariable ['GUI_BCG_RGB_G',0.7019])", "(profilenamespace getvariable ['GUI_BCG_RGB_B',0.8862])", 0.5};
           onbuttonclick = [] spawn cptjustiz_fnc_getLocation;
           x = 0.45;
           y = 0.35;
           w = (6.25 / 40);
           h = (1 / 25);
       };
       class CloseButtonKey : Life_RscButtonMenu
       {
           idc = 19002;
           text = "$STR_Global_Close";
           onbuttonclick = "closeDialog 0;";
           x = 0.45;
           y = 0.40;
           w = (6.25 / 40);
           h = (1 / 25);
       };
   };
};