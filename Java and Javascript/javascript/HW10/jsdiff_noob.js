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

function Add(first, second) {
    this.first = first;
    this.second = second;
}

Add.prototype = {
    evaluate: function(x, y, z) { return this.first.evaluate(x, y, z) + this.second.evaluate(x, y, z); },
    diff: function(d) { return new Add(this.first.diff(d), this.second.diff(d)); },
    toString: function() { return (this.first + " " + this.second + " + "); }
}

function Subtract(first, second) {
    this.first = first;
    this.second = second;
}

Subtract.prototype = {
    evaluate: function(x, y, z) { return this.first.evaluate(x, y, z) - this.second.evaluate(x, y, z); },
    diff: function(d) { return new Subtract(this.first.diff(d), this.second.diff(d)); },
    toString: function() { return (this.first + " " + this.second + " - "); }
}

function Multiply(first, second) {
    this.first = first;
    this.second = second;
}

Multiply.prototype = {
    evaluate: function(x, y, z) { return this.first.evaluate(x, y, z) * this.second.evaluate(x, y, z); },
    diff: function(d) { return new Add(new Multiply(this.first.diff(d), this.second),
                                       new Multiply(this.first, this.second.diff(d))); },
    toString: function() { return (this.first + " " + this.second + " * "); }
}

function Divide(first, second) {
    this.first = first;
    this.second = second;
}

Divide.prototype = {
    evaluate: function(x, y, z) { return this.first.evaluate(x, y, z) / this.second.evaluate(x, y, z); },
    diff: function(d) { return new Divide(new Subtract(new Multiply(this.first.diff(d), this.second),
                                                      new Multiply(this.first, this.second.diff(d))),
                                          new Multiply(this.second, this.second)); },
    toString: function() { return (this.first + " " + this.second + " / "); }
}

function Sin(once) {
    this.once = once;
}
 
Sin.prototype = {
    evaluate: function (x, y, z) { return Math.sin(this.once.evaluate(x, y, z)); },
    diff: function(d) { return new Multiply(new Cos(this.once), this.once.diff(d)); },
    toString: function() { return (this.once + " sin "); }
}
function Cos(once) {
    this.once = once;
}
 
Cos.prototype = {
    evaluate: function (x, y, z) { return Math.cos(this.once.evaluate(x, y, z)); },
    diff: function(d) { return new Subtract(new Const(0),
                                            new Multiply(new Sin(this.once), this.once.diff(d))); },
    toString: function() { return (this.once + " cos "); }
}     

//print(parse("x sin").toString());


/*function BinaryOperation(first, second, f, d, ts) {
    this.first = first;
    this.second = second;
    this.f = f;
    this.d = d;
    this.ts = ts;
}

BynaryOperation.prototype = {
    evaluate: 
        function(x, y, z) {
            return this.f(this.first.evaluate(x, y, z), this.second.evaluate(x, y, z));
        },
    diff:
        function(d) {
            return this.d(this.first, this.second, d);
        },
    toString: function() { return this.ts(first, second); }

}

function Add(first, second) = BinaryOperation(first, 
                                              second, 
                                              function(a, b) { return a + b; },
                                              function(a, b, d) { return new Add(a.diff(d), b.diff(d)); },
                                              function(a, b) { return (a + " " + b + " + "); });

*/
/*var binary_operation = function(f) {
    return function(a, b) {
        return function(x, y, z) {
            return f(a(x, y, z), b(x, y, z));
        }
    }
}

var unary_operation = function(f) {
    return function(a) {
        return function(x, y, z) {
            return f(a(x, y, z));
        }
    }
}

var add = binary_operation(function(a, b) { return a + b; });
var subtract = binary_operation(function(a, b) { return a - b; });
var multiply = binary_operation(function(a, b) { return a * b; });
var divide = binary_operation(function(a, b) { return a / b; });
var sin = unary_operation(function(a) { return Math.sin(a); });
var cos = unary_operation(function(a) { return Math.cos(a); });
*/


