///<reference path="./circle.ts"/>  
//reference should always on top of the file 


let myName='Sagar';

//  myName=45  this is not posiible so it TS is called strong typing or static typing

let mySurname:string='Pachkhande' //can declare like this also

let age; //it is implicitly any type i.e age:any
age='gh';
age =22;


console.log(myName)

console.log(mySurname)

console.log(age)

// --------------------------------------------------

let sample: boolean | string;

sample='rakshanda'
sample=true

console.log("sample: ",sample)

//----------------------------------------Array-----------------

let a=[132,true,'sagar','g']

// let a:any[]=[132,true,'sagar','g'] a array internally works as like this

console.log("array a is::",a);

let b:string[]=['sagar','pachkhande']
console.log("array b is::",b)

//----------------------------------------Tuples-----------------

let c:[string,number,boolean]=['sagar',78,true] //whatever datatype mentioned in the tuple need to be assigned and value in same order and all type of value must be mentioned

console.log(c)

//----------------------------------------Enum-----------------

enum Color{
    red,green,blue,black
}

console.log("green color is at the position::\n",Color.green);
enum Color1{
    a=200,b,c,d
}

// console.log("after assingning value for a=200 the value of c is\n",Color1.c);
// enum day{
//     1='sunday',2='monday',3='tuesday',4='wednesday'
// }
// console.log(day["2"]);

// ------------------------------------------class---------------------


class Person {

    name: string;
    age: number;
    constructor(nm:string,ag:number){
       this.name=nm;
       this.age=ag;

    }
}
let person=new Person('sagar',22);

console.log("Person name is::",person.name)
  
// Another Method of declaring constructor

class Person2{
    constructor(public personName:string,public personAge:number){

    }
}
let person2=new Person2('sagar',22)
console.log("mine age is ",person2.personAge)

class Static_NonStatic{
    name: string='BMW'; // Non static member acccess by creating object
    static model:string='x5'; //static member acccess by class name
}
let bmwCar=new Static_NonStatic();

console.log("----Nonsatic and Static class---")
console.log("non static members access::"+bmwCar.name);

console.log("Static member "+Static_NonStatic.model);

console.log("")

class Parameter_Constructor{
    constructor(public brand:string,public model:string){

    }
    name: string='BMW'; // Non static member acccess by creating object
    static model:string='x5'; //static member acccess by class name
}

let  Car=new Parameter_Constructor('Lamborgini','KS5');
console.log(Car.brand);
console.log(Car.model);
console.log("")



//---------------------Inheritance-------------------

class ParentClass{
    salary:number=12345;
    constructor(public name:string,public age:number){

    }
}
//childClass will invokes all the properties from parent class
class ChildClass extends ParentClass{
    constructor(public nm:string,public age:number,public USN:number){
        super(nm,age);
    }
}

// let parentobject=new ParentClass('sagar',22);

let childobject=new ChildClass('dinga',34,1234354543)

console.log(childobject.salary);

class Pappa{
    constructor(public name:string ,public age ?: number){  //    ?: defines thet the parametre is not mandatory to pass from any method or object
        
    }
}

let p1:Pappa={
    name:'sagar'
}
let p2:Pappa={
    name: 'abc',
    age:289
}

// -----------------------------Interface----------------

// 1. only declaration is possible not initialization is possible
// 2. only abstract method is allowed

interface Student{
    name:string;            //only declaration is possible not initialization is possible
    age:number;

    printDetailes():void  ;  // only abstract method is allowed
}

class Per implements Student{
    name='ABC';
    age=90;
    printDetailes(){
        console.log("Name is "+this.name)
    }
}

let per1=new Per();
per1.printDetailes();

//object of interface
// but we have to initialise the memebrs and provide the defination of the interface in the object creation of an interface 
let ss1:Student= {
    name:'xyz',
    age:34,
    printDetailes:()=>{
        console.log("Interface object creation:: Name is "+ss1.name);
    }
}

ss1.printDetailes();;



// Generics:: It offers a way to creat reusable com[onentes]. generic provides a way to make

function getArray(items:string[]){
    return new Array().concat(items)
}
console.log(getArray(['10,5,45','hdhs']));

///this generic will take a 'p' as a datatype of array that will treated as the single datatype 
// i.e if we provide the array with string then it will treated as a string array and in case of number array 'p' will treated as numeric array
function getArray1<p>(items1:p[]):p[]{
    return new Array<p>().concat(items1)
}
let strArray=getArray1<string>(['sagar','pachkhande']);

let numArray=getArray1<number>([56,7,8]);

numArray.push(78);
console.log(strArray);
console.log(numArray)



// namespace MathOperation{
//     const pi=3.14;
//     export function CircumferenceOfCircle(radius: number){
//         console.log("The circumference of circle is "+2*pi*radius)
//     }

//     export function AreaOfCircle(radius:number){
//         console.log('The Area of Circle is '+pi*radius*radius)
//     }
//     export namespace rectangle{                                //nested namespace
//         export function area(length:number,breadth:number){
//             console.log("Area of rectangle is "+length*breadth);
//         }
//     }
// }
// MathOperation.CircumferenceOfCircle(7);
MathOperation.rectangle.area(7,8);  //calling the method of area nested namespace rectangle


