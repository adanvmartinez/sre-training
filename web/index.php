<?php
$user = "my-username";
$password = "my-super-secret-password";
$database = "information_schema";

$table = "";

try {
    $db = new PDO("mysql:host=test-db-1.ccmmazsopssp.us-west-1.rds.amazonaws.com;dbname=$database", $user, $password);

   $result  = $db->query("SELECT table_name FROM INFORMATION_SCHEMA.TABLES");
  // print([$result]);



        print("<div style='font-family: Helvetica; display: flex; flex-direction: column; align-items:center;'>
        <div style='width:40%;'><h3>Day 4 Assignment Notes</h3>
        <p>Create an RDS on a private network and create a EC2 instance on a public subnet with access
to internet. EC2 instance must be able to access RDS instance, but RDs instance may not have public
access. Once those two are communicating, create an application to display DB connection to the public.</p></div>

<div style='width:40%'>
<h3>Day 4 Assignment Steps</h3>
<ul>
        <li> First, I created a VPC</li>
        <li>Next, I created two subnets on the VPC, one private and one public.</li>
        <li>After that, I created two route tables. One public and one private.</li>
        <li>Once I created the route tables, I created an Internet Gateway and attached it to the VPC</li>
        <li>Next, I attached route tables to their respective subnets.</li>
        <li>Then, I set the public route table as the main route table.</li>
        <li>Then, I created an EC2 and RDS instace.</li>
        <li>After that, I creted a security policy for EC2 to allow traffic on SSH port and HTTP port</li>
        <li>Once that was added, I edited the security group for RDS and added the ID for the EC2 security
                group so that it allows all traffic (this is called a nested security group).</li>
        <li>Once that was completed, I ran mysql command fron EC2 terminal to make sure that it was able
                to connect to RDS instance, and it was successful.</li>
        <li>Once the EC2 instance had connection with RDS, I installed NGINX on the EC2 instance, and
                modified the configuration to run serve a php script that I created. This php file is a
                a simple db connection that queries the tables table on the informatio_schema.</li>
        <li>After the script file was finished and configuration was updated, I was able to access the
                application from the internet and it displays table names from the RDS instance. This mean
                that I bealieve the assignment conditions were met.</li></ul>
</div>

</div>");

  print("<h2 style='font-family:Helvetica, Arial, Sans-Serif;'>Result from connecting to Adan's RDS and querying the information schema for all tables available...</h2>");
        print("<div style='font-family:Helvetica, Arial, Sans-Serif; display:flex; flex-direction:column; align-items:center'>");
   foreach($result as $row){
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
