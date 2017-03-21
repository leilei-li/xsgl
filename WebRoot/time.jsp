<script language="javascript">
    var currentDate = new Date(<%=new java.util.Date().getTime()%>);   
       function run() {       
          currentDate.setSeconds(currentDate.getSeconds() + 1);          
          document.getElementById("currentTime").innerHTML = currentDate.toLocaleString();     
          }     
          window.setInterval("run();", 1000); 
    </script>