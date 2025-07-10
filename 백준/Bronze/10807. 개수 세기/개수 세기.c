#include <stdio.h>

int main(){
    int N, cnt=0;
    scanf("%d", &N);
    int arr[100];

    for(int i=0; i<N; i++){
        scanf("%d", &arr[i]);
    }
    
    int v, count=0;
    scanf("%d", &v);
    for(int i=0; i<N; i++){
        if(arr[i] == v){
            count++;
        }
    }
    printf("%d", count);
}