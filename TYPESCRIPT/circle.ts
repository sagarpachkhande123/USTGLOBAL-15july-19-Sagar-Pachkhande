
// The namespace is used to logical grouping of functionalities
// A namespace can include interface, classes, function and varible to support a single or a group of related functionlities
// A namespace can be created using the namespace keyword followed by the namespace name
// all interfaces, classes etc can be defined in the curly bracess

// syntax{
//  namespace sagar{

//  }
// }

namespace MathOperation{
    const pi=3.14;
    export function CircumferenceOfCircle(radius: number){
        console.log("The circumference of circle is "+2*pi*radius)
    }

    export function AreaOfCircle(radius:number){
        console.log('The Area of Circle is '+pi*radius*radius)
    }
    export namespace rectangle{                                //nested namespace
        export function area(length:number,breadth:number){
            console.log("Area of rectangle is "+length*breadth);
        }
    }
}
MathOperation.CircumferenceOfCircle(7);
