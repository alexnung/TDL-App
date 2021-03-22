'use strict';

const peopleElement = document.querySelector("#read-p");
peopleElement.addEventListener("click", (event) => {
  event.preventDefault();
  read_people();
});

const readPersonElement = document.querySelector("#read-one-p").disabled = true;
//readPersonElement.addEventListener("click", (event) => {
//  event.preventDefault();
//});

const createPersonElement = document.querySelector("#create-p");
createPersonElement.addEventListener("click", (event) => {
  event.preventDefault();
  create_task();
});

const updatePersonElement = document.querySelector("#update-p");
updatePersonElement.addEventListener("click", (event) => {
  event.preventDefault();
  update_task();
});

const deletePersonElement = document.querySelector("#delete-p");
deletePersonElement.addEventListener("click", (event) => {
  event.preventDefault();
  delete_task();
});


let read_people = () => {
  fetch("http://localhost:8080/people").then((res) => {
    res.json().then((data) => {
      if (data.length > 0) {
        console.log(data);
        document.querySelector("#people-head").style.display = "initial";
        alert("Displaying all records");

        var temp = "";
          data.forEach((p) => {
          temp += "<tr>";
          temp += "<td>" + p.id + "</td>";
          temp += "<td>" + p.name + "</td>";
          temp += "<td>" + p.title + "</td>";
          temp += "<td>" + JSON.stringify(p.tasks) + "</td>";
        });
    /*
    temp += "<tr>";
                    temp += "<td>" + u.pokeListId + "</td>";
                    temp += "<td>" +u.pokeList + "</td>";

                    temp += "<tr>";
                  
                   
                    u.pokeTasks.forEach((task) => {console.log(JSON.stringify(task))
                    
                    temp += "<tr>" +task.taskId + "</tr>";
                    temp += "<td>" +task.pokeTask + "</td>";
                    temp += "<td>" +task.pokeTaskDescription + "</td>";
                    temp += "<td>" +task.difficulty + "</td>";
                    temp += "<td>" +task.date + "</td>";
                    temp += "<td>" +task.completed + "</td>";

                    })
                    document.getElementById("PokePlanner_Table").innerHTML = temp;
                    
                  });
    */    
        document.querySelector("#people").innerHTML = temp;
      }
      if (!data.length > 0) {
        console.log("No records available");
        document.querySelector("#people-head").style.display = "none";
        alert("No records available");
      }
    });
  });
};

let create_task = () => {
  let name = document.querySelector("#name").value;
  console.log("Name: " + name);
  let title = document.querySelector("#Job-Title").value;
  console.log("Title: " + title);

  const createdPerson =
  {
      "name": name,
      "title": title
  }
  fetch("http://localhost:8080/people", {
      method: "POST",
      headers: {
          "Content-type": "application/json"
      },
      body: JSON.stringify(createdPerson)
  })

      .then(res => res.json())
      .then(data => console.log(data))
      .catch(err => console.err(err))
}

let update_task = () => {
  let taskId = parseInt(document.querySelector("#pID").value);
  console.log("People ID: " + taskId);
  let name = document.querySelector("#name").value;
  console.log("Name: " + name);
  let title = document.querySelector("#Job-Title").value;
  console.log("Title: " + title);

  const updatedPerson = {
    "name": name,
    "title": title
  };

  fetch(`http://localhost:8080/people/id/${taskId}`, {
    method: "PUT",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify(updatedPerson),
  })
    .then((res) => res.json())
    .then((data) => console.log(`Request succeeded with JSON response ${data}`))
    .catch((error) => console.log(`Request failed ${error}`));
};

let delete_task = async (peopleId) => {
  var peopleId = parseInt(document.querySelector("#pID").value);
  const response = await fetch(`http://localhost:8080/people/id/${peopleId}`, {
    method: "DELETE",
  });
  if (response.status != 204) {
    alert(
      "Issue with delete request, please check that ID is correct or present"
    );
    console.error(`Error: Status code ${response.status}\n${response.json}`);
    return response.status;
  }
  alert("Person deleted");
  console.log("Person with ID:" + peopleId + " was deleted");
};
