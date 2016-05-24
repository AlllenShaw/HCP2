<?php
//通过用户名获取ecg列表
//数据库参数
$dabip="localhost";
//$dabip="172.18.43.70:3306";
$dbname="root";
//$dbpw="pw137907";
$dbpw="admin";
//$dbuse="hmap";
$dbuse="hcp";
$qarayn="patient";
$getname=$_POST["usename"];
//连接数据库
$con = mysql_connect($dabip, $dbname, $dbpw); //本地数据库
if (!$con)
 {
 die('Could not connect: ' . mysql_error());
 }
//选择数据库
mysql_select_db($dbuse, $con);  

//获取指定名称对应id

$sql="SELECT id FROM $qarayn WHERE username='$getname'";  
//$sql="SELECT ecg FROM htn_patient_record WHERE measure_time=$mtime";  
$result = mysql_query($sql);
//调试代码
/*echo "<table border='1'>     */
//数据处理
$row = mysql_fetch_row($result); //处理结果集
$paid=(int)$row[0];                  //处理字符串 
$i=0;
$arr_gultime=array();
if($paid==0){
    $arr_gultime[0]="not found this people";
    echo json_encode($arr_gultime);
}

else{
//获取id对应ecg列表
$getimesql="SELECT measure_time FROM htn_patient_record WHERE patient_id=$paid"; 
$getresult= mysql_query($getimesql);
$length_gultime=mysql_num_rows($getresult);
for($i=0;$i<$length_gultime;$i++){
   $gultdata=mysql_fetch_row($getresult);
   $arr_gultime[$i]=$gultdata[0];
}
echo json_encode($arr_gultime);  //以json格式输出数组
//print_r($arr_gultime);
}

mysql_close($con);
?>
