<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<header>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="<%=basePath %>echarts/dist/echarts.min.js"></script>
</header>
<body>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main1" style="width: 600px;height:400px;"></div>
<div id="main2" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main1'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts from Zero.(it\'s my first echarts demo.)'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {},
        series: [{
            name: 'number',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    var myChart_b = echarts.init(document.getElementById('main2'));
    myChart_b.setOption({
        backgroundColor: '#2c343c',
        series : [
            {
                name: '访问来源',
                type: 'pie',
                roseType: 'angle',
                radius: '80%',
                data:[
                    {value:400, name:'搜索引擎'},
                    {value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:274, name:'联盟广告'},
                    {value:235, name:'视频广告'}
                ]
            }
        ]
    });







</script>
</body>

</html>