// 원소들의 곱과 합
// 정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.
// function solution(num_list) {
//     var answer = 0;
//     var product = 1
//     var sum = 0

//     for (var index = 0; index < num_list.length; index++){
//         product = product * num_list[index];
//         sum = sum + num_list[index];
//     }
//     square = sum * sum;
//     if (product < square){
//         answer = 1;
//     }
//     else{
//         answer = 0;
//     }
//     return answer;
// }

// 이어 붙인 수
// 정수가 담긴 리스트 num_list가 주어집니다. num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.
var num_list = [3,4,5,2,1];
var answer = 0;
var odd = [];
var even = [];
for (var index = 0; index < num_list.length; index++){
    if (num_list[index] % 2 != 0){
        odd.push(num_list[index]);
    }
    else{
        even.push(num_list[index])
    }
}
var oddJoin = odd.join('');
let evenJoin = even.join('');
answer = Number(oddJoin) + Number(evenJoin);
console.log(answer)

