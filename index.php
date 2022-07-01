<?php
$user = "myusername";
$password = "my-super-secret-password";
$database = "information_schema";

$table = "";

try {
    $db = new PDO("mysql:host=test-db-1.ccmmazsopssp.us-west-1.rds.amazonaws.com;dbname=$database", $user, $password);

   $result  = $db->query("SELECT table_name FROM INFORMATION_SCHEMA.TABLES");
  // print([$result]);


  print("<h2 style='font-family:Helvetica, Arial, Sans-Serif;'>Result from connecting to Adan's RDS and querying the information>
        print("<div style='font-family:Helvetica, Arial, Sans-Serif; display:flex; flex-direction:column; align-items:center'>");   foreach($result as $row){
        //print($row);
        //print("<div style='width:100vw; display:flex;'>");
        for($i=0; $i < count($row); $i++){
                print("<div style='width:20%;'>".$row[$i]."</div>");
                }
        //print("</div>");
        print("</br>");
        }
        print("</div>");
// echo "<h2>Members List</h2><ol>"; foreach($db->query("SELECT * FROM information_schema.tables") as $row) {
  //      echo "<li>" . $row['content'] . "</li>";
    //}
   // echo "</ol>";
}   catch (PDOException $e) {
    print "Error!: " . $e->getMessage() . "<br/>"; die();
}
?>
