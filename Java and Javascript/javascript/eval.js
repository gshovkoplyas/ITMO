var cnst = function(c) {
	return function(x, y, z) {
  		return c;
  	}
}

var variable = function(str) {
	return function(x, y, z) {
  		if (str == "x") {
    		return x;
  		} else if (str == "y") {
    		return y;
  		} else if (str == "z") {
    		return z;
  		}
  		return 0;
  	}
}

var binary_operation = function(f) {
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
var log = unary_operation(function(a) { return Math.log(a); });
var abs = unary_operation(function(a) { return Math.abs(a); });
var pow = binary_operation(function(a, b) { return Math.pow(a, b); });
var pi = cnst(Math.PI);
var sin = unary_operation(function(a) { return Math.sin(a); });

function is_ident(c) {
	return (c[0] >= "0" && c[0] <= "9") || (c == "x" || c == "y" || c == "z");
}

function is_operator(c) {
	return (c == "+" || c == "-" || c == "*" || c == "/" || c == "log" || c == "abs");
}

function is_variable(c) {
	return (c == "x" || c == "y" || c == "z") ;
}

function op_argument_count(c) {
	if (c == "+" || c == "-" || c == "*" || c == "/") {
  		return 2;
  	} else if (c == "log" || c == "abs") {
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
				stack.push(variable(c));
			} else {
				stack.push(cnst(Number(c)));
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
	 	 			stack.push(add(first, second));
	 	 		} else if (c == "-") {
	 	 			stack.push(subtract(first, second));
	 	 		} else if (c == "*") {
	 	 			stack.push(multiply(first, second));
	 	 		} else if (c == "/") {
	 	 			stack.push(divide(first, second));
	 	 		} 
	 	 	} else if (op_argument_count(c) == 1) {
	 	 		var once = stack.pop();
	 	 		if (c == "log") {
	 	 			stack.push(log(once));
	 	 		} else if (c == "abs") {
	 	 			stack.push(abs(once));
	 	 		} 
	 	 	}

		}
	}
	return stack.pop();
}

/*println("==x==|===x^2-2*x+1===========");
var expr = add(
	subtract(
		multiply(
			variable("x"), 
			variable("x")
		), 
		multiply(
			cnst(2), 
			variable("x")
		)
	), 
	cnst(1)
);

for (var i = 0; i <= 10; i++) {
    if (i < 10) {
		println("  " + i + "  |       " +  expr(i));
	} else {
		println(" " + i + "  |       " +  expr(i));
	}

}

println("============parse============");
var request = "x x 2 - * x * 1 +";
var x = 5;
println("answer for \"" + request + "\" with x = " + x + " is: " + parse(request)(x, 0, 0));
*/

