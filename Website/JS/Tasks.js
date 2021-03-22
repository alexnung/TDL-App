"use strict";

const readElement = document.querySelector("#read");
readElement.addEventListener("click", (event) => {
  event.preventDefault();
  read_tasks();
});

const readOneElement = document.querySelector("#read-one").disabled = true;
//readOneElement.addEventListener("click", (event) => {
//  event.preventDefault();
//  read_tasks_id();
//});

const createElement = document.querySelector("#create");
createElement.addEventListener("click", (event) => {
  event.preventDefault();
  create_task();
});

const updateElement = document.querySelector("#update");
updateElement.addEventListener("click", (event) => {
  event.preventDefault();
  update_task();
});

const deleteElement = document.querySelector("#delete");
deleteElement.addEventListener("click", (event) => {
  event.preventDefault();
  delete_task();
});

let read_tasks = () => {
  fetch("http://localhost:8080/tasks").then((res) => {
    res.json().then((data) => {
      if (data.length > 0) {
        console.log(data);
        document.querySelector("#tasks-head").style.display = "initial";
        alert("Displaying all records");

        var temp = "";

        data.forEach((t) => {
          temp += "<tr>";
          temp += "<td>" + t.id + "</td>";
          temp += "<td>" + t.task + "</td>";
          temp += "<td>" + t.dueDate + "</td>";
          temp += "<td>" + t.status + "</td>";
        });
        document.querySelector("#tasks").innerHTML = temp;
      }
      if (!data.length > 0) {
        console.log("No records available");
        document.querySelector("#tasks-head").style.display = "none";
        alert("No records available");
      }
    });
  });
};

let read_tasks_id = (taskId) => {
    var taskId = parseInt(document.querySelector("#tID").value);
    fetch(`http://localhost:8080/tasks/id/${taskId}`).then((res) => {
      res.json().then((data) => {
        if (data.length > 0) {
          console.log(data);
          document.querySelector("#tasks-head").style.display = "initial";
          alert("Displaying all records");
  
          let lists = Object.values
          var temp = "";
  
          data.forEach((t) => {
            temp += "<tr>";
            temp += "<td>" + t.id + "</td>";
            temp += "<td>" + t.task + "</td>";
            temp += "<td>" + t.dueDate + "</td>";
            temp += "<td>" + t.status + "</td>";
          });
          document.querySelector("#tasks").innerHTML = temp;
        }
        if (!data.length > 0) {
          console.log("No records available");
          document.querySelector("#tasks-head").style.display = "none";
          alert("No records available");
        }
      });
    });
  };
  
/*
  let read_tasks_id = async () => {
    let taskId = parseInt(document.querySelector("#tID").value);
  fetch(`http://localhost:8080/tasks/id/${taskId}`)
  .then((response) => {
      if (response.status !== 200) {
          alert("Invalid or missing ID")
          console.log("Invalid or missing ID")
          console.error(`Error: Status code ${response.status}\n${response.json}`);
          return;
      }
  response.json().
  then((data) => console.log(data));   
  console.error(`Error: Status code ${response.status}\n${response.json}`); 
   })
  .catch ((err) => console.log(`Fetch Error :-S ${err}`)
  );
};
*/
let create_task = () => {
    let task = document.querySelector("#task").value;
    console.log("Task: " + task);
    let due_date = document.querySelector("#due-date").value;
    console.log("Due Date: " + due_date);
    let status = document.querySelector("#status").value;
    console.log("Status: " + status);
    let completed_on_time = document.querySelector("#completed-on-time").value;
    console.log("Completed On Time: " + completed_on_time);
    let pID = parseInt(document.querySelector("#people-id").value);
    console.log("Person ID: " + pID);

    const createdTask =
    {
        "task": task,
        "dueDate": due_date,
        "status": status,
        "completedOnTime": completed_on_time,
        "people":
        {
            "id": pID
        }
    }
    fetch("http://localhost:8080/tasks", {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(createdTask)
    })

        .then(res => res.json())
        .then(data => console.log(data))
        .catch(err => console.err(err))
}




let update_task = () => {
  let taskId = parseInt(document.querySelector("#tID").value);
  console.log("Task ID: " + taskId);
  let task = document.querySelector("#task").value;
  console.log("Tasks: " + task);
  let due_date = document.querySelector("#due-date").value;
  console.log("Due Date: " + due_date);
  let status = document.querySelector("#status").value;
  console.log("Status: " + status);
  let completed_on_time = document.querySelector("#completed-on-time").value;
  console.log("Completed on time: " + completed_on_time);

  const updatedTask = {
    "task": task,
    "dueDate": due_date,
    "status": status,
    "completedOnTime": completed_on_time
  };

  fetch(`http://localhost:8080/tasks/id/${taskId}`, {
    method: "PUT",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify(updatedTask),
  })
    .then((res) => res.json())
    .then((data) => console.log(`Request succeeded with JSON response ${data}`))
    .catch((error) => console.log(`Request failed ${error}`));
};

let delete_task = async (taskId) => {
  var taskId = parseInt(document.querySelector("#tID").value);
  const response = await fetch(`http://localhost:8080/tasks/id/${taskId}`, {
    method: "DELETE",
  });
  if (response.status != 204) {
    alert(
      "Issue with delete request, please check that ID is correct or present"
    );
    console.error(`Error: Status code ${response.status}\n${response.json}`);
    return response.status;
  }
  alert("Task deleted");
  console.log("Task with ID:" + taskId + " was deleted");
};


