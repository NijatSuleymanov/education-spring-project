
var allStudents;
function getStudents(){
    const xhttp = new XMLHttpRequest();
    function MyFunction(){
        const responseText = this.responseText;
        const responseArr = JSON.parse(responseText);
        allStudents = responseArr;
        var tr = document.getElementById("tbl-students-body-tr").innerHTML;
        var tblBody = "";
        for(var i = 0; i < responseArr.length; i++){
            var student = responseArr[i];

            tblBody += tr
                .replaceAll(":id", student.id)
                .replaceAll(":index", i)
                .replace(":firstName", student.firstName)
                .replace(":surname", student.surname)
                .replace(":email", student.email)
                .replace(":age", student.age)
                .replace(":university", student.university.name);
        }

        document.getElementById("tbl-students-body").innerHTML = tblBody ;
    }
    xhttp.onload = MyFunction;
    xhttp.open("GET","http://localhost:9090/education/students?" +
        "name=" + val("name") + "&" +
        "surname=" + val("surname") + "&" +
        "email=" + val("email") + "&" +
        "age=" + val("age") + "&" +
        "university_id=" + val("university_id"));
    xhttp.send();
}

function getUniversities(){
    const xhttp = new XMLHttpRequest();
    function MyFunction(){
        const responseArr = JSON.parse(this.responseText);
        var optionsHtml = '<option value="" selected></option>';
        for(var i = 0; i < responseArr.length; i++){
            var university = responseArr[i];

            optionsHtml += '<option value="'
                + university.id +
                '">'
                + university.name +
                '</option>';
        }

        document.getElementById("university_id").innerHTML = optionsHtml;
        document.getElementById("create_university_id").innerHTML = optionsHtml;
        document.getElementById("update_university_id").innerHTML = optionsHtml;
    }
    xhttp.onload = MyFunction;
    xhttp.open("GET","http://localhost:9090/education/university");
    xhttp.send();
}
function val(elementId){
    var value = document.getElementById(elementId).value;
    return value!==null && value!=='undefined'? value:'';
}

var selectedId;
function select(id){
    selectedId = id;
}
function deleteStudent(id){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function (){
      if( xhttp.status = "200"){
          getStudents();
      }
    }
    xhttp.open("DELETE","http://localhost:9090/education/students?id="+id);
    xhttp.send();
}
function insertStudent(id){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function (){
        if( xhttp.status = "200"){
            getStudents();
        }
    }

    var student = {
        firstName: document.getElementById("create_name").value,
        surname: document.getElementById("create_surname").value,
        email: document.getElementById("create_email").value,
        age: document.getElementById("create_age").value,
        university: {
            id: document.getElementById("create_university_id").value
        }
    }
    xhttp.open("POST","http://localhost:9090/education/students");
    xhttp.setRequestHeader("Content-Type","application/json");
    xhttp.send(JSON.stringify(student));
}

function updateStudent(id){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function (){
        if( xhttp.status = "200"){
            getStudents();
        }
    }

    var student = {
        id: selectedId,
        firstName: document.getElementById("update_name").value,
        surname: document.getElementById("update_surname").value,
        email: document.getElementById("update_email").value,
        age: document.getElementById("update_age").value,
        university: {
            id: document.getElementById("update_university_id").value
        }
    }
    xhttp.open("PUT","http://localhost:9090/education/students");
    xhttp.setRequestHeader("Content-Type","application/json");
    xhttp.send(JSON.stringify(student));
}

function selectForUpdate(index){
    var selectedStudent = allStudents[index];
    document.getElementById("update_name").value =  selectedStudent.firstName;
    document.getElementById("update_surname").value =  selectedStudent.surname;
    document.getElementById("update_email").value =  selectedStudent.email;
    document.getElementById("update_age").value =  selectedStudent.age;
    document.getElementById("update_university_id").value =  selectedStudent.university.id;
    selectedId = selectedStudent.id;
}


window.addEventListener("load", getStudents);
window.addEventListener("load", getUniversities);

