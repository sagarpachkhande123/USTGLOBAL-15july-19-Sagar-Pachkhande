function printConstructors(cons: Function){
    console.log(cons);
}
@printConstructors
class Sample{
    constructor(){
        console.log('Hi I am Sample Class Constructor')
    }
}
