var person = {
    firstName: "John",
    lastName: "Doe",
    id: 5566,
    fullName: function () {
        return "fullName为："+this.firstName + " " + this.lastName;
    }
};

function getPersonFullName(){
    //fullName需要加()，不加()它会返回函数的定义：
    document.getElementById("person").innerHTML = person.fullName();
}

function updatePerson(firstName,lastName){
    person.firstName = firstName;
    person.lastName = lastName;
}


