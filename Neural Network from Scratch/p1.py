# coding of a single neuron

# Starting input (can be output of previous layer or true input(say sensors))
inputs = [1, 2, 3, 2.5]
# Every neuron has a weight (randomly assigned to it)
weights = [0.2, 0.8, -0.5, 1.0]
# Bias of the neuron (but it has 3 inputs hence 3 input and weight)
# Since bias is of the neuron, only 1 bias present
bias = 2

output = inputs[0]*weights[0] + inputs[1]*weights[1] + inputs[2]*weights[2] + inputs[3]*weights[3] + bias
print(output)