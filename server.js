

//Author: Adan Martinez

const express = require('express');
const path = require('path');
const mysql = require('mysql');


const app = express();


//DB Credentials //These should be store in an .env file
const host = 'my-db-host';//These should be store in an .env file
const user = 'my-username';//These should be store in an .env file
const password = 'my-super-secret-password';//These should be store in an .env file
const database = 'my-schema';//These should be store in an .env file



app.get('/',(req, res)=>{

        //console.log(req.headers);
        const con = mysql.createConnection({
                host:host,
                user:user,
                password:password,
                database:database
        });

        con.connect((err)=>{
                if(err){ res.send('Error connection to RDS');
                return;};
        });
        let ip = req.headers['x-forwarded_for'];
        console.log(`Request IP: ${ip}`);

        con.query(`INSERT INTO conn_app_visits_log (id, ip, time_visited) values(default, "${ip}", default)`);

        con.end();

        res.sendFile(path.join(__dirname, '/index.html'));
});


app.get('/index.js',(req, res)=>res.sendFile(path.join(__dirname, '/index.js')));

app.get('/visits',(req, res)=>{
        const con = mysql.createConnection({
                host:host,
                user:user,
                password:password,
                database:database
        });
         con.connect((err)=>{
                if(err){ res.send('Error connection to RDS');
                return;};
        });

        con.query('SELECT ip, time_visited from conn_app_visits_log', (err, rows)=>{
                if(err) res.send('Error getting data from RDS');
                res.send(rows);
                //console.log(rows);
        });


});


app.listen(3000, ()=>console.log('Node server listening on port 3000'));
