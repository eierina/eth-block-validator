pragma solidity ^0.8.0;

contract Counter {
    uint256 counter;

    function increment() external returns (uint256 value) {
        value = ++counter;
    }

    function decrement() external returns (uint256 value) {
        value = --counter;
    }
}