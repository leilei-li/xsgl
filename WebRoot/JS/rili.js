var msgSearch2={};
   msgSearch2={
    '120': '日',
    '121': '一',
    '122': '二',
    '123': '三',
    '124': '四',
    '125': '五',
    '126': '六',
    '127': '一月',
    '128': '二月',
    '129': '三月',
    '130': '四月',
    '131': '五月',
    '132': '六月',
    '133': '七月',
    '134': '八月',
    '135': '九月',
    '136': '十月',
    '137': '十一月',
    '138': '十二月',
    '139': '今天',
    '140': '取消',
    '141': '清空'
   }
   /*
   用途：检索提交按钮脚本，用于提交检索
   参数：action    提交类型
   参数：param     传入参数（带入URL中）
   */
   
  
   function isDate(str) {
       if (arguments.length != 1) 
           return false; 
       var iaDate = new Array(3); 
       iaDate = str.toString().split("-"); 
       if (iaDate.length == 1) 
           return IsYear(iaDate[0]); 
       else if (iaDate.length == 2 && IsYear(iaDate[0]) && IsMonth(iaDate[1])) 
           return true; 
       var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); 
       if (r == null)
           return false;
       var d = new Date(r[1], r[3] - 1, r[4]); 
       return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[4]);
   }
   function IsYear(sDate) {
       if (sDate == '1000' || sDate == '3000')
           return true; 
       if (sDate.length != 4) 
           return false; 
       var year = parseFloat(sDate); 
       if (isNaN(year)) return false;
       if (year < 1900 || year > 2100) 
           return false; 
       return true;
   }
   function IsMonth(sDate)
   { if (sDate == '' || sDate.length > 2) 
       return false; 
     var month = parseFloat(sDate);
     if (month < 1 || month > 12) 
       return false; 
     return true; 
   }
   function compareDate(strStartDate, strEndDate) {
       var aryStartDate = strStartDate.split('-'); var aryEndDate = strEndDate.split('-'); var length = aryStartDate.length > aryEndDate.length ? aryEndDate.length : aryStartDate.length
       for (var i = 0; i < aryStartDate.length; i++) {
           if (i == 0) {
               if (aryStartDate[i] - aryEndDate[i] > 0)
               { return false; }
           }
           else if (i == 1)
           { if (aryStartDate[0] == aryEndDate[0] && aryStartDate[i] - aryEndDate[i] > 0) { return false; } }
           else if (i == 2) {
               if (aryStartDate[0] == aryEndDate[0] && aryStartDate[1] == aryEndDate[1] && aryStartDate[i] - aryEndDate[i] > 0)
                   return false;
           }
       }
       return true;
   }
   //***************End*********************
   //***************PopupCalendar.js***********
   var oCalendarEn = new PopupCalendar("oCalendarEn"); //初始化控件时,请给出实例名称如:oCalendarEn
   oCalendarEn.Init();
   var oCalendarChs = new PopupCalendar("oCalendarChs"); //初始化控件时,请给出实例名称:oCalendarChs 
   oCalendarChs.weekDaySting = new Array(msgSearch2['120'], msgSearch2['121'], msgSearch2['122'], msgSearch2['123'], msgSearch2['124'], msgSearch2['125'], msgSearch2['126']);
   oCalendarChs.monthSting = new Array(msgSearch2['127'], msgSearch2['128'], msgSearch2['129'], msgSearch2['130'], msgSearch2['131'], msgSearch2['132'], msgSearch2['133'], msgSearch2['134'], msgSearch2['135'], msgSearch2['136'], msgSearch2['137'], msgSearch2['138']);
   oCalendarChs.oBtnTodayTitle = msgSearch2['139'];
   oCalendarChs.oBtnCancelTitle = msgSearch2['140'];

   oCalendarChs.Init();
   document.onclick = DocumentClick;
   function isIE() {
       if (window.navigator.userAgent.toString().toLowerCase().indexOf("msie") >= 1)
           return true;
       else
           return false;
   }
   function PopupCalendar(InstanceName) {
       ///Global Tag
       this.instanceName = InstanceName;
       ///Properties
       this.separator = ""
       this.oBtnTodayTitle = "Today"
       this.oBtnClearTitle = "Clear"
       this.oBtnCancelTitle = "Cancel"
       this.weekDaySting = new Array("S", "M", "T", "W", "T", "F", "S");
       this.monthSting = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
       this.Width = 250;
       this.currDate = new Date();
       this.today = new Date();
       this.startYear = 2010;
       this.endYear = 2020;
       ///Css
       this.normalfontColor = "#666666";
       this.selectedfontColor = "red";
       this.divBorderCss = "1px solid #BCD0DE";
       this.titleTableBgColor = "#98B8CD";
       this.tableBorderColor = "#CCCCCC"
       ///Method
       this.Init = CalendarInit;
       this.Fill = CalendarFill;
       this.Refresh = CalendarRefresh;
       this.Restore = CalendarRestore;
       ///HTMLObject
       this.oTaget = null;
       this.oPreviousCell = null;
       this.sDIVID = InstanceName + "_Div";
       this.sTABLEID = InstanceName + "_Table";
       this.sMONTHID = InstanceName + "_Month";
       this.sYEARID = InstanceName + "_Year";
       this.sTODAYBTNID = InstanceName + "_TODAYBTN";
       this.bgIframeID = InstanceName + "_Iframe";
      

   }
   function CalendarInit()				///Create panel
   {
       var sMonth, sYear
       sMonth = this.currDate.getMonth();
       sYear = this.currDate.getFullYear();
       var htmlAll = "<div id='" + this.sDIVID + "' style='display:none;Z-INDEX: 999;position:absolute;width:" + this.Width + ";border:" + this.divBorderCss + ";padding:2px;background-color:#FFFFFF'>";
       htmlAll += "<div align='center' nowrap>";
       /// Month
       htmloMonth = "&nbsp;&nbsp;&nbsp;&nbsp;<select id='" + this.sMONTHID + "' onchange=CalendarMonthChange(" + this.instanceName + ") style='width:80'>";
       for (i = 0; i < 12; i++) {
           htmloMonth += "<option value='" + i + "'>" + this.monthSting[i] + "</option>";
       }
       htmloMonth += "</select>";
       /// Year
       htmloYear = "<select id='" + this.sYEARID + "' onchange=CalendarYearChange(" + this.instanceName + ") style='width:80'>";
       for (i = this.startYear; i <= this.endYear; i++) {
           htmloYear += "<option value='" + i + "'>" + i + "</option>";
       }
       htmloYear += "</select></div>";
       /// Day
       htmloDayTable = "<table id='" + this.sTABLEID + "' width='250' border=0 cellpadding=0 cellspacing=1 bgcolor='" + this.tableBorderColor + "'>";
       htmloDayTable += "<tbody bgcolor='#ffffff'style='font-size:13px'>";
       for (i = 0; i <= 6; i++) {
           if (i == 0)
               htmloDayTable += "<tr bgcolor='" + this.titleTableBgColor + "'>";
           else
               htmloDayTable += "<tr>";
           for (j = 0; j < 7; j++) {

               if (i == 0) {
                   htmloDayTable += "<td height='20' align='center' valign='middle' style='cursor:pointer'>";
                   htmloDayTable += this.weekDaySting[j] + "</td>"
               }
               else {
                   htmloDayTable += "<td height='20' align='center' valign='middle' style='cursor:pointer'";
                   htmloDayTable += " onmouseover=CalendarCellsMsOver(this," + this.instanceName + ")";
                   htmloDayTable += " onmouseout=CalendarCellsMsOut(this," + this.instanceName + ")";
                   htmloDayTable += " onclick=CalendarCellsClick(this," + this.instanceName + ")>";
                   htmloDayTable += "&nbsp;</td>"
               }
           }
           htmloDayTable += "</tr>";
       }
       htmloDayTable += "</tbody></table>";
       /// Today Button
       htmloButton = "<div align='center' style='padding:3px' nowrap>"
       htmloButton += "<input type='button' id='" + this.sTODAYBTNID + "' style='width:100;border:1px solid #BCD0DE;background-color:#eeeeee;cursor:pointer'";
       htmloButton += " onclick=CalendarTodayClick(" + this.instanceName + ")  value='" + this.oBtnTodayTitle + "'/>&nbsp;";
       htmloButton += "&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' style='width:100;border:1px solid #BCD0DE;background-color:#eeeeee;cursor:pointer'";
       htmloButton += " onclick=CalendarCancel(" + this.instanceName + ")  value='" + this.oBtnCancelTitle + "'/>&nbsp;";
       htmloButton += "</div>";
       /// All
       htmlAll = htmlAll + htmloMonth + htmloYear + htmloDayTable + htmloButton + "</div>";
       htmlAll += "<iframe id=" + this.bgIframeID + " scrolling='no' frameborder='0' style='position:absolute; top:0px; left:0px; Z-INDEX: 998; display:none;filter=progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0);'></iframe>";

       //alert(htmlAll);
       document.write(htmlAll);
       this.Fill();
   }
   function CalendarFill()			///
   {
       var sMonth, sYear, sWeekDay, sToday, oTable, currRow, MaxDay, iDaySn, sIndex, rowIndex, cellIndex, oSelectMonth, oSelectYear
       sMonth = this.currDate.getMonth();
       sYear = this.currDate.getFullYear();
       sWeekDay = (new Date(sYear, sMonth, 1)).getDay();
       sToday = this.currDate.getDate();
       iDaySn = 1
       oTable = document.getElementById(this.sTABLEID);
       currRow = oTable.rows[1];
       MaxDay = CalendarGetMaxDay(sYear, sMonth);

       oSelectMonth = document.getElementById(this.sMONTHID);
       oSelectMonth.selectedIndex = sMonth;

       oSelectYear = document.getElementById(this.sYEARID);
       for (i = 0; i < oSelectYear.length; i++) {
           if (parseInt(oSelectYear.options[i].value) == sYear) oSelectYear.selectedIndex = i;
       }

       for (rowIndex = 1; rowIndex <= 6; rowIndex++) {
           if (iDaySn > MaxDay) break;
           currRow = oTable.rows[rowIndex];
           cellIndex = 0;
           if (rowIndex == 1) cellIndex = sWeekDay;
           for (; cellIndex < currRow.cells.length; cellIndex++) {
               if (iDaySn == sToday) {
                   currRow.cells[cellIndex].innerHTML = "<font color='" + this.selectedfontColor + "'><i><b>" + iDaySn + "</b></i></font>";
                   this.oPreviousCell = currRow.cells[cellIndex];
               }
               else {
                   currRow.cells[cellIndex].innerHTML = iDaySn;
                   currRow.cells[cellIndex].style.color = this.normalfontColor;
               }
               CalendarCellSetCss(0, currRow.cells[cellIndex]);
               iDaySn++;
               if (iDaySn > MaxDay) break;
           }
       }


   }
   function CalendarRestore()					/// Clear Data
   {
       var i, j, oTable
       oTable = document.getElementById(this.sTABLEID);
       for (i = 1; i < oTable.rows.length; i++) {
           for (j = 0; j < oTable.rows[i].cells.length; j++) {
               CalendarCellSetCss(0, oTable.rows[i].cells[j]);
               oTable.rows[i].cells[j].innerHTML = "&nbsp;";
           }
       }
   }
   function CalendarRefresh(newDate)					///
   {
       this.currDate = newDate;
       this.Restore();
       this.Fill();
   }
   function GetMonthDay(index)
   { var iaMonthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]; var dd = iaMonthDays[index]; return dd; }
   function CalendarCellsMsOver(elem, oInstance)				/// Cell MouseOver
   {
       //firefox不支持event modify by limx 20100625
       var myCell = elem;
       CalendarCellSetCss(0, oInstance.oPreviousCell);
       if (myCell) {
           CalendarCellSetCss(1, myCell);
           oInstance.oPreviousCell = myCell;
       }
   }
   function CalendarCellsMsOut(elem, oInstance)				////// Cell MouseOut
   {
       var myCell = elem;
       CalendarCellSetCss(0, myCell);
   }
   function CalendarYearChange(oInstance)				/// Year Change
   {
       var sDay, sMonth, sYear, newDate
       sDay = oInstance.currDate.getDate();
       sMonth = oInstance.currDate.getMonth();
       sYear = document.getElementById(oInstance.sYEARID).value;
       newDate = new Date(sYear, sMonth, sDay);
       oInstance.Refresh(newDate);
       sDateString = sYear + oInstance.separator + CalendarDblNum(sMonth + 1) + oInstance.separator + CalendarDblNum(sDay); 	///return sDateString
       if (oInstance.oTaget.tagName.toLowerCase() == "input") {
           oInstance.oTaget.value = sDateString;
       }
   }
   function CalendarMonthChange(oInstance)				/// Month Change
   {
       var sDay, sMonth, sYear, newDate
       sDay = oInstance.currDate.getDate();
       sMonth = document.getElementById(oInstance.sMONTHID).value;
       sMonth = parseInt(sMonth);
       sYear = oInstance.currDate.getFullYear();
       newDate = new Date(sYear, sMonth, sDay);
       oInstance.Refresh(newDate);
       sDateString = sYear + oInstance.separator + CalendarDblNum(sMonth + 1) + oInstance.separator + CalendarDblNum(sDay); 	///return sDateString
       if (oInstance.oTaget.tagName.toLowerCase() == "input") {
           oInstance.oTaget.value = sDateString;
       }
   }

   //双击日期
   function CalendarCellsClick(oCell, oInstance) {
       var sDay, sMonth, sYear, newDate
       sYear = oInstance.currDate.getFullYear();
       sMonth = oInstance.currDate.getMonth();
       sDay = oInstance.currDate.getDate();
       var txt = oCell.innerText ? oCell.innerText : oCell.textContent;
       txt = txt.replace(/(^\s*)|(\s*$)/g, "");
       if (typeof (txt) != "undefined" && txt.length > 0)
           sDay = parseInt(txt);
       if (sDay != oInstance.currDate.getDate()) {
           newDate = new Date(sYear, sMonth, sDay);
           oInstance.Refresh(newDate);
       }

       sDateString = sYear + oInstance.separator + CalendarDblNum(sMonth + 1) + oInstance.separator + CalendarDblNum(sDay); 	///return sDateString
       if (oInstance.oTaget.tagName.toLowerCase() == "input") {
           oInstance.oTaget.value = sDateString;
       }
       CalendarCancel(oInstance);
       return sDateString;
   }
   function CalendarTodayClick(oInstance)				/// "Today" button Change
   {
       oInstance.Refresh(new Date());
       sYear = oInstance.currDate.getFullYear();
       sMonth = oInstance.currDate.getMonth();
       sDay = oInstance.currDate.getDate();
       sDateString = sYear + oInstance.separator + CalendarDblNum(sMonth + 1) + oInstance.separator + CalendarDblNum(sDay);
       if (oInstance.oTaget.tagName.toLowerCase() == "input") {
           oInstance.oTaget.value = sDateString;
       }
      HideCalendar(oInstance);
   }
   //add by fuhw 2008.04.25  点击今天后窗口隐藏
   function HideCalendar(oInstance)
   {
       var CalendarDiv = document.getElementById(oInstance.sDIVID);
       var bgIframe = document.getElementById(oInstance.bgIframeID);
       try {
           CalendarDiv.style.display = "none";
           bgIframe.style.display = "none";
           CalendarDiv.style.visibility = "hide";
           bgIframe.style.visibility = "hide";
       } catch (err) { }
   }
   var ActiveInstance; //当前活动的Calendar
   function getDateString(oInputSrc, oInstance) {
       if (oInputSrc && oInstance) {
           var CalendarDiv = document.getElementById(oInstance.sDIVID);
           var bgIframe = document.getElementById(oInstance.bgIframeID);
           oInstance.oTaget = oInputSrc;
           ActiveInstance = oInstance;

           if (!isIE()) {
               bgIframe.style.left = CalendarDiv.style.left = CalendargetPos(oInputSrc, "Left") + "px";
               bgIframe.style.top = CalendarDiv.style.top = CalendargetPos(oInputSrc, "Top") + oInputSrc.offsetHeight + "px";
           }
           else {
               bgIframe.style.pixelLeft = CalendarDiv.style.pixelLeft = CalendargetPos(oInputSrc, "Left");
               bgIframe.style.pixelTop = CalendarDiv.style.pixelTop = CalendargetPos(oInputSrc, "Top") + oInputSrc.offsetHeight;
           }
           try {
               bgIframe.style.display = CalendarDiv.style.display = (CalendarDiv.style.display == "none") ? "" : "none";
               bgIframe.style.visibility = CalendarDiv.style.visibility = (CalendarDiv.style.visibility == "hide") ? "visible" : "hide";
           } catch (err) { }

           bgIframe.width = CalendarDiv.scrollWidth;
           bgIframe.height = CalendarDiv.scrollHeight;
       }
   }
   function CalendarCellSetCss(sMode, oCell)			/// Set Cell Css
   {
       // sMode
       // 0: OnMouserOut 1: OnMouseOver 
       if (sMode) {
           oCell.style.border = "1px solid #5589AA";
           oCell.style.backgroundColor = "#BCD0DE";
       }
       else {
           oCell.style.border = "1px solid #FFFFFF";
           oCell.style.backgroundColor = "#FFFFFF";
       }
   }
   function CalendarGetMaxDay(nowYear, nowMonth)			/// Get MaxDay of current month
   {
       var nextMonth, nextYear, currDate, nextDate, theMaxDay
       nextMonth = nowMonth + 1;
       if (nowYear == 99)
           nowYear = 1999;

       if (nextMonth > 11) {
           nextYear = nowYear + 1;
           nextMonth = 0;
       }
       else {
           nextYear = nowYear;
       }

       currDate = new Date(nowYear, nowMonth, 1);
       nextDate = new Date(nextYear, nextMonth, 1);

       theMaxDay = (nextDate - currDate) / (24 * 60 * 60 * 1000);

       return theMaxDay;
   }
   function CalendargetPos(el, ePro)				/// Get Absolute Position
   {
       var ePos = 0;
       while (el != null) {
           ePos += el["offset" + ePro];
           el = el.offsetParent;
       }
       return ePos;
   }
   function CalendarDblNum(num) {
       if (num < 10)
           return "0" + num;
       else
           return num;
   }
   function CalendarCancel(oInstance)			///Cancel
   {
       var CalendarDiv = document.getElementById(oInstance.sDIVID);
       var bgIframe = document.getElementById(oInstance.bgIframeID);
       try {
           CalendarDiv.style.display = "none";
           bgIframe.style.display = "none";
           CalendarDiv.style.visibility = "hide";
           bgIframe.style.visibility = "hide";
       } catch (err) { }
   }
   function DocumentClick(event) {
       if (ActiveInstance) {
           var CalendarDiv = document.getElementById(ActiveInstance.sDIVID);
           //firefox 不支持event,event.srcElement和 contains，换之modify by limx 20100625
           event = event ? event : window.event;
           var srcelemt = event.srcElement ? event.srcElement : event.target;
           if (oCalendarChs.oTaget != srcelemt && !ElemContain(CalendarDiv, srcelemt)) {
               CalendarCancel(oCalendarChs);
           }
       }
   }

   //判断元素包含，firefox不支持contains 
   function ElemContain(pnode, cnode) {
       var ishas = false;
       var ctag = cnode.tagName;
       var cnodes = pnode.getElementsByTagName(ctag);
       for (var i in cnodes) {
           if (cnodes[i] == cnode) {
               ishas = true;
               break;
           }
       }
       return ishas;
   }
   //***************End*********************
   //***************页面********************
   function Init() {
       ShowDiv('c_' + dbCatalog); try { SearchInit(dbCatalog); $("#dblist").val(GetGroupValue('selectdatabase', dbCatalog)); $("#db_value").val($("#dblist").val()); HideDiv("divtip"); } catch (e) { }
       var xls = document.getElementById('txt_extension'); if (xls != null)
           xls.checked = true; if ($("#ischkd").val() != null) {ChangeHideNavi(); MainWordlable(); }
   }
   function LoadCopyright() {
       $.ajax({
           type: "get",
           url: "/Grid2008/datacenter/GetCommonHTML.ashx",
           data: "action=html&postion=index_bottom&t=" + new Date().getSeconds(),
           success: function(msg) {
               $("#bottomContent").html(msg);
           }
       });
   }
   //***************End********************