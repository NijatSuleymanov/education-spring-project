function getStudents(){
    const xhttp = new XMLHttpRequest();
    function MyFunction(){
        const responseText = this.responseText;
        const responseArr = JSON.parse(responseText);
        var tr = document.getElementById("tbl-students-body-tr").innerHTML;
        var tblBody = "";
        for(var i = 0; i < responseArr.length; i++){
            var student = responseArr[i];

            tblBody += tr
                .replaceAll(":id", student.id)
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


window.addEventListener("load", getStudents);
window.addEventListener("load", getUniversities);

