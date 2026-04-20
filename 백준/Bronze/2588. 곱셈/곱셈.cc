#include <iostream>
using namespace std;

int main(){
    int a, b, b1,b2,b3;
    cin >> a >> b;
    b1 = b%10;
    b2 = (b%100 - b1)/10;
    b3 = b/100;
    
    cout << b1*a << endl << b2*a << endl << b3*a << endl << a*b;
}