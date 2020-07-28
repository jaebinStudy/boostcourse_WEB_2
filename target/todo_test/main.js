function move(id, type) {
    var xhr = new XMLHttpRequest();
    xhr.addEventListener("load", function () {
        if (type == "TODO") {
            var parent = document.getElementById("doing");
            var newItem = document.getElementById(id);
            newItem.removeChild(newItem.children[2]);
            var text = "<input type=\"button\" onclick=\"move(\'" + id + "\' ,\'DOING\');\" value=\"->\" \/>";
            newItem.insertAdjacentHTML('beforeend', text);
            console.log(newItem.children);
            parent.appendChild(newItem);
        } else {
            var parent = document.getElementById("done");
            console.log(parent);
            var newItem = document.getElementById(id);
            console.log(newItem);
            newItem.removeChild(newItem.children[2]);
            parent.appendChild(newItem);
        }
    });
    xhr.open("POST", "/ToDo/todotype");
    xhr.setRequestHeader('Content-Type',
        'application/x-www-form-urlencoded');
    xhr.send("id=" + id + "&type=" + type);
}
