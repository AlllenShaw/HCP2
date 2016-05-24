<?php
//通过特定用户的ecg测量时间唯一的获取ecg数据
//传参
$mtime=$_POST["thetime"];
//变量
//数据库参数
$dabip="localhost";
$dbname="root";
$dbpw="admin";
$dbuse="hcp";
$qarayn="hd_patient_record";
//连接数据库
$con = mysql_connect($dabip, $dbname, $dbpw); //本地数据库
if (!$con)
 {
 die('Could not connect: ' . mysql_error());
 }
//选择数据库
mysql_select_db($dbuse, $con);  
//数据库操作
//$sql="SELECT ecg FROM $qarayn";  
$sql="SELECT ecg FROM $qarayn WHERE measure_time='$mtime'";  
$result = mysql_query($sql);
//调试代码
/*echo "<table border='1'>     */
//数据处理
$row = mysql_fetch_row($result); //处理结果集
$data0=$row[0];                  //处理字符串
$data1=trim($data0,'[');
$data=trim($data1,']');
$data_array=explode(',',$data); //字符串转成数组  
//print_r($data_array);
echo json_encode($data_array);  //以json格式输出数组
mysql_close($con);
?>

