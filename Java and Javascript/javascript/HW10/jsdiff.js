function is_ident(c) {
    return (c[0] >= "0" && c[0] <= "9") || (c == "x" || c == "y" || c == "z");
}

function is_operator(c) {
    return (c == "+" || c == "-" || c == "*" || c == "/" || c == "sin" || c == "cos");
}

function is_variable(c) {
    return (c == "x" || c == "y" || c == "z") ;
}

function op_argument_count(c) {
    if (c == "+" || c == "-" || c == "*" || c == "/") {
        return 2;
    } else if (c == "cos" || c == "sin") {
        return 1;
    }
    return 0;
}

function parse(expression) {
    var stack = [];
    for (var i = 0; i < expression.length; i++) {
         var c = "";
         while (i < expression.length && expression[i] != " ") {
            c = c + expression[i];
            i++;
         }
         if (is_ident(c)) {
            if (is_variable(c)) {
                stack.push(new Variable(c));
            } else {
                stack.push(new Const(Number(c)));
            }
         } else if (is_operator(c)) {
            if (stack.length < op_argument_count(c)) {
                println("There is some error");
                return;
            }
            if (op_argument_count(c) == 2) {
                var second = stack.pop();
                var first = stack.pop();
                if (c == "+") {
                    stack.push(new Add(first, second));
                } else if (c == "-") {
                    stack.push(new Subtract(first, second));
                } else if (c == "*") {
                    stack.push(new Multiply(first, second));
                } else if (c == "/") {
                    stack.push(new Divide(first, second));
                } 
            } else if (op_argument_count(c) == 1) {
                var once = stack.pop();
                if (c == "sin") {
                    stack.push(new Sin(once));
                } else if (c == "cos") {
                    stack.push(new Cos(once));
                } 
            } 

        }
    }
    return stack.pop();
}

function Const(c) {
    this.c = c;
}

Const.prototype = {
    evaluate: function(x, y, x) { return this.c; },
    diff: function(v) { return new Const(0); },
    toString: function() { return this.c; }
}

function Variable(v) {
    this.v = v;
}
 
Variable.prototype = {
    evaluate: 
        function(x, y, z) {
            str = this.v;
            if (str == "x") {
                return x;
            } else if (str == "y") {
                return y;
            } else if (str == "z") {
                return z;
            }
            return 0;
        },
    diff:
        function(d) {
            if (this.v == d) {
                return new Const(1);
            } 
            return new Const(0);
        },
    toString: function() { return this.v; }
}

var unaryOperation = { 
    evaluate: function(x, y, z) { return this.operation(this.once.evaluate(x, y, z)); },
    diff: function(d) { return this.derivative(d); },
    toString: function() { return (this.once + " " + this.string); }
}

var binaryOperation = { 
    evaluate: 
        function(x, y, z) { 
            return this.operation(this.first.evaluate(x, y, z), this.second.evaluate(x, y, z)); 
        },
    diff: function(d) { return this.derivative(d); },
    toString: function() { return (this.first + " " + this.second + " " + this.string); }
}

function Add(first, second) {
    this.first = first;
    this.second = second;
    this.operation = function(first, second) { return first + second; }
    this.derivative = function(d) { return new Add(this.first.diff(d), this.second.diff(d)); }
    this.string = "+";
}


function Subtract(first, second) {
    this.first = first;
    this.second = second;
    this.operation = function(first, second) { return first - second; }
    this.derivative = function(d) { return new Subtract(this.first.diff(d), this.second.diff(d)); }
    this.string = "-";
}

function Multiply(first, second) {
    this.first = first;
    this.second = second;
    this.operation = function(first, second) { return first * second; }
    this.derivative = function(d) { 
        return new Add(new Multiply(this.first.diff(d), second),
                       new Multiply(this.first, this.second.diff(d))); 
    }
    this.string = "*";
}

function Divide(first, second) {
    this.first = first;
    this.second = second;
    this.operation = function(first, second) { return first / second; }
    this.derivative = function(d) { 
        return new Divide(new Subtract(new Multiply(this.first.diff(d), this.second),
                                       new Multiply(this.first, this.second.diff(d))),
                          new Multiply(this.second, this.second)); 
    }
    this.string = "/";
}

function Sin(once) {
    this.once = once;
    this.operation = function(once) { return Math.sin(once); }
    this.derivative = function(d) { return new Multiply(new Cos(this.once), this.once.diff(d)); },
    this.string = "sin";
}
 
function Cos(once) {
    this.once = once;
    this.operation = function(once) { return Math.cos(once); }
    this.derivative = function(d) { 
        return new Subtract(new Const(0), new Multiply(new Sin(this.once), this.once.diff(d))); 
    }
    this.string = "cos";
}
 
Add.prototype = binaryOperation;
Subtract.prototype = binaryOperation;
Multiply.prototype = binaryOperation;
Divide.prototype = binaryOperation;
Sin.prototype = unaryOperation;
Cos.prototype = unaryOperation;

