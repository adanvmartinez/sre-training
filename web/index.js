
//Author: Adam Martinez

//console.log('Index.js sadfsdf');

document.addEventListener('DOMContentLoaded', (event) => {

        const  getData = async ()=>{
                const result = await fetch('/visits');
                const data =  await result.json();
                return data;
        };



        let data = getData().then(visits=>{
                let container = document.getElementById('table-container');
                let header1 = document.createElement('div');
                header1.style.display = 'flex';
                header1.style.justifyContent = 'space-evenly';
                header1.style.width = '100%';
                let header2 = document.createElement('div');
                header2.style.width = '30%';
                header2.innerHTML = '<h3>IP of Site Visitor</h3>';
                let header3 = document.createElement('div');
                header3.style.width='70%';
                header3.innerHTML = '<h3>Time of Visit</h3>';

                header1.appendChild(header2);
                header1.appendChild(header3);
                container.appendChild(header1);

                visits.map(visit=>{
                        let row = document.createElement('div');
                        row.style.display = 'flex';
                        row.style.justifyContent = 'space-evenly';
                        row.style.width = '100%';

                        let ip = document.createElement('div');
                        ip.style.width = '30%';
                        let time = document.createElement('div');
                        time.style.width = '70%';


                        ip.innerText = visit.ip;
                        time.innerText = Date().toLocaleString(visit.time_visited);

                        row.appendChild(ip);
                        row.appendChild(time);

                        container.appendChild(row);
                });
        });




});
