function String(str, start, end) {
    this.str = str || new Array();    
    this.start = start || 0;
    this.end = end || this.str.length;
}

String.prototype = {
    at: function(index) {
        if (index < this.length()) {
            return this.str[this.start + index];
        } else {
            throw "out of bound error in at";
        }
    },
    add: function(character) {
        this.str[this.end] = character;
        this.end++;
    },
    insert: function(index, character) {
        if (index <= this.length()) {
            var old_length = this.length();
            for (var i = this.end; i > this.start + index; i--) {
                this.str[i] = this.str[i - 1];
            }
            this.str[this.start + index] = character;
            this.end++;
        } else {
            throw "out of bound error in insert";
        }
    },
    length: function() {
        return this.end - this.start;
    },
    concat: function(str) {
        if (str instanceof String) {
            var result = new String();
            for (var i = 0; i < this.length(); i++) {
                result.add(this.at(i));
            }
            for (var i = 0; i < str.length(); i++) {
                result.add(str.at(i));
            }
            return result;
        } else {
            throw "wrong argument format error in concat";
        }
    }, 
    beginsWith: function(str) {
        if (str instanceof String) {
            if (str.length() > this.length()) {
                return false;
            } else {
                var result = true;
                for (var i = 0; i < str.length(); i++) {
                    if (str.at(i) != this.at(i)) {
                        result = false;
                    }
                }
                return result;
            }
        } else {
            throw "wrong argument format error in beginsWith";
        }
    },
    endsWith: function(str) {
        if (str instanceof String) {
            if (str.length() > this.length()) {
                return false;
            } else {
                var result = true;
                for (var i = 0; i < str.length(); i++) {
                    if (str.at(str.length() - i - 1) != this.at(this.length() - i - 1)) {
                        result = false;
                    }
                }
                return result;
            }
        } else {
            throw "wrong argument format error in endsWith";
        }
    },
    equals: function(str) {
        if (str instanceof String) {
            if (str.length() != this.length()) {
                return false;
            } else {
                var result = true;
                for (var i = 0; i < str.length(); i++) {
                    if (str.at(i) != this.at(i)) {
                        result = false;
                    }
                }
                return result;
            }
        } else {
            return false;
        }
    },
    substring: function(start, end) {
        end = end || (this.length() - 1);
        if (start >= 0 && end < this.length() && start < end) {
            return new String(this.str, this.start + start, this.start + end);
        } else {
            throw "wrong index error in substring";
        }
  
    } 
}

var s = new String();
var c = new String();
s.add('c');
s.add('a');
s.add('l');
s.insert(1, 'z');
c.add('c');
c.add('a');
c.add('l');
s = c.concat(s);
s = s.substring(2);
println(s.length());
for (var i = 0; i < s.length(); i++) {
    print(s.at(i));
}
println("");



















































