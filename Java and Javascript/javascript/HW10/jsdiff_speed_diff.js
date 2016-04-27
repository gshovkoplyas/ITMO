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
    toString: function() { 
        if (this.c < 0) {
            return ("0 " + -this.c + " -");
        }
        return this.c; 
    }
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
    this.derivative = function(d) { 
        var first_diff = this.first.diff(d);
        var second_diff = this.second.diff(d);
        if (first_diff instanceof Const && second_diff instanceof Const) {
            return new Const(this.operation(first_diff.c, second_diff.c));
        }
        if (first_diff instanceof Const && first_diff.c == 0) {
            return second_diff;
        }
        if (second_diff instanceof Const && second_diff.c == 0) {
            return first_diff;
        }
        return new Add(first_diff, second_diff); 
    }
    this.string = "+";
}

function Subtract(first, second) {
    this.first = first;
    this.second = second;
    this.operation = function(first, second) { return first - second; }
    this.derivative = function(d) { 
        var first_diff = this.first.diff(d);
        var second_diff = this.second.diff(d);
        if (first_diff instanceof Const && second_diff instanceof Const) {
            return new Const(this.operation(first_diff.c, second_diff.c));
        }
        if (second_diff instanceof Const && second_diff.c == 0) {
            return first_diff;
        }
        return new Subtract(first_diff, second_diff); 
    }
    this.string = "-";
}

function Multiply(first, second) {
    this.first = first;
    this.second = second;
    this.operation = function(first, second) { return first * second; }
    this.derivative = function(d) { 
        var first_diff = this.first.diff(d);
        var second_diff = this.second.diff(d);
        var first = new Multiply(first_diff, this.second);
        var second = new Multiply(this.first, second_diff);
        if (first_diff instanceof Const && first_diff.c == 0) {
            first = new Const(0);
        }
        if (second_diff instanceof Const && second_diff.c == 0) {
            second = new Const(0);
        } 
        var ans = new Add(first, second);
        if (first instanceof Const && second instanceof Const) {
            return new Const(ans.operation(first.c, second.c));
        }
        if (first instanceof Const && first.c == 0) {
            return second;
        }
        if (second instanceof Const && second.c == 0) {
            return first;
        } 
        return ans; 
    }
    this.string = "*";
}

function Divide(first, second) {
    this.first = first;
    this.second = second;
    this.operation = function(first, second) { return first / second; }
    this.derivative = function(d) { 
        var first_diff = this.first.diff(d);
        var second_diff = this.second.diff(d);
        var first = new Multiply(first_diff, this.second);
        var second = new Multiply(this.first, second_diff);
        if (first_diff instanceof Const && first_diff.c == 0) {
            first = new Const(0);
        }
        if (second_diff instanceof Const && second_diff.c == 0) {
            second = new Const(0);
        } 
        var numerator = new Subtract(first, second);
        var denumerator = new Multiply(this.second, this.second);
        if (this.second instanceof Const) {
            denumerator = new Const(denumerator.operation(this.second, this.second));
        }
        if (first instanceof Const && second_diff instanceof Const) {
            numerator = new Const(numerator.operation(first.c, second.c));
        }
        if (second instanceof Const && second.c == 0) {
            numerator = first;
        }
        if (numerator instanceof Const && numerator.c == 0) {
            return new Const(0);
        } 
        return new Divide(numerator, denumerator); 
    }
    this.string = "/";
}

function Sin(once) {
    this.once = once;
    this.operation = function(once) { return Math.sin(once); }
    this.derivative = function(d) { 
        var first = new Cos(this.once);
        var second =  this.once.diff(d);
        if (this.once instanceof Const) {
            first = new Const(this.operation(this.once.c));
        }
        if (first instanceof Const && first_diff.c == 0) {
            first = new Const(0);
        }
        if (second instanceof Const && second_diff.c == 0) {
            second = new Const(0);
        }
        return new Multiply(new Cos(this.once), this.once.diff(d)); 
    }
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

