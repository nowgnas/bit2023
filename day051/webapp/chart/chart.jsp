<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
let chart = {
	init:function(){
		$.ajax({
			url:'rest.bit?cmd=chart1',
			success:function(result){
				chart.display(result);
			}
		});
	},
	display:function(result){
		Highcharts.chart('container', {
		    chart: {
		        type: 'line'
		    },
		    title: {
		        text: 'Monthly Average Temperature'
		    },
		    subtitle: {
		        text: 'Source: ' +
		            '<a href="https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature" ' +
		            'target="_blank">Wikipedia.com</a>'
		    },
		    xAxis: {
		        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
		    },
		    yAxis: {
		        title: {
		            text: 'Temperature (°C)'
		        }
		    },
		    plotOptions: {
		        line: {
		            dataLabels: {
		                enabled: true
		            },
		            enableMouseTracking: false
		        }
		    },
		    series: result
		});

	}
};
$(document).ready(function(){
	chart.init();
});

</script>


<div class="container" style="margin-top:30px">
  <div class="row">
   
    <div class="col-sm-12">
      <h2>Chart</h2>
      <div id="container"></div>
    </div>
   
  </div>
</div>