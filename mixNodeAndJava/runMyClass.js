const java = require("java");
java.classpath.push("./src");
java.classpath.push('java.io.File');
java.classpath.push('java.util.ArrayList');
java.classpath.push('java.util.List');
java.classpath.push('../lib/fastjson-1.2.49.jar');

let MyClass = java.import("com.cn.test.PathToTree");

let result = MyClass.DDDSync("C:\\Windows\\debug");
console.log(result);