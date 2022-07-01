<?php 
$user = "myusername"; 
$password = "mysupersecretpassword"; 
$database = "information_schema"; 

$table = ""; 

try {
    $db = new PDO("mysql:host=test-db-1.ccmmazsopssp.us-west-1.rds.amazonaws.com;dbname=$database"
, $user, $password); 
   
   $result  = $db->query("SELECT table_name FROM INFORMATION_SCHEMA.TABLES");
  // print([$result]);
  

  print("<h2>Result from connecting to Adan's RDS and querying the information schema for all tabl
es available...</h2>");

   foreach($result as $row){
//print($row);
//print("<div style='width:100vw; display:flex;'>");
for($i=0; $i < count($row); $i++){
print("<div>".$row[$i]."</div>");
}
//print("</div>");
print("</br>");
}
// echo "<h2>Members List</h2><ol>"; foreach($db->query("SELECT * FROM information_schema.tables")
 as $row) {
  //      echo "<li>" . $row['content'] . "</li>";
    //}
   // echo "</ol>";
}   catch (PDOException $e) {
    print "Error!: " . $e->getMessage() . "<br/>"; die();
}
?>
