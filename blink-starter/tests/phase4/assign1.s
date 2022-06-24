# visit StartNode
.data
	.comm	_x, 8, 4
	.comm	_y, 8, 4
	.comm	_b1, 8, 4
	.comm	_b2, 8, 4
	.comm	_b3, 8, 4
	.comm	_a, 8, 4
	.comm	_b, 8, 4
	.comm	_y2, 8, 4
	.comm	_c, 8, 4
	.comm	_d, 8, 4

.text

# visit DeclarationNode.MethodDeclaration
.globl start
start:
	pushq	%rbp
	movq	%rsp, %rbp
	subq	$48, %rsp
# visit DeclarationNode.VariableDeclaration
	pushq	$5 # visit ExpressionNode.Int
	popq	_x(%rip)
# visit DeclarationNode.VariableDeclaration
# visit ExpressionNode.Multiply
	pushq	_x(%rip) # visit ExpressionNode.Identifier
# visit ExpressionNode.Subtract
	pushq	$8 # visit ExpressionNode.Int
	pushq	_x(%rip) # visit ExpressionNode.Identifier
	popq	%r10
	popq	%rax
	subq	%r10, %rax
	pushq	%rax
	popq	%r10
	popq	%rax
	imul	%r10
	pushq	%rax
	popq	_y(%rip)
# visit DeclarationNode.VariableDeclaration
	pushq	$1 # visit ExpressionNode.Bool
	popq	_b1(%rip)
# visit DeclarationNode.VariableDeclaration
	pushq	$0 # visit ExpressionNode.Bool
	popq	_b2(%rip)
# visit DeclarationNode.VariableDeclaration
# visit ExpressionNode.Not
# visit ExpressionNode.Or
# visit ExpressionNode.Not
	pushq	_b2(%rip) # visit ExpressionNode.Identifier
	popq	%r10
	xorq	$1, %r10
	pushq	%r10
	pushq	_b1(%rip) # visit ExpressionNode.Identifier
	popq	%r10
	popq	%r11
	or	%r10, %r11
	pushq	%r11
	popq	%r10
	xorq	$1, %r10
	pushq	%r10
	popq	_b3(%rip)
# visit DeclarationNode.VariableDeclaration
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
	pushq	_y(%rip) # visit ExpressionNode.Identifier
	popq	%rdi
	callq	printint
	addq	$16, %rsp
	pushq	%rax
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	movq	-24(%rbp), %rdx
	movq	-32(%rbp), %rcx
	movq	-40(%rbp), %r8
	movq	-48(%rbp), %r9
	popq	_a(%rip)
# visit DeclarationNode.VariableDeclaration
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
# visit ExpressionNode.Divide
	pushq	_x(%rip) # visit ExpressionNode.Identifier
	pushq	$2 # visit ExpressionNode.Int
	popq	%r10
	popq	%rax
	idiv	%r10
	pushq	%rax
	popq	%rdi
	callq	printint
	addq	$16, %rsp
	pushq	%rax
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	movq	-24(%rbp), %rdx
	movq	-32(%rbp), %rcx
	movq	-40(%rbp), %r8
	movq	-48(%rbp), %r9
	popq	_b(%rip)
# visit DeclarationNode.VariableDeclaration
# visit ExpressionNode.Subtract
	pushq	_y(%rip) # visit ExpressionNode.Identifier
	pushq	_x(%rip) # visit ExpressionNode.Identifier
	popq	%r10
	popq	%rax
	subq	%r10, %rax
	pushq	%rax
	popq	_y2(%rip)
# visit DeclarationNode.VariableDeclaration
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
# visit ExpressionNode.Add
	pushq	_y2(%rip) # visit ExpressionNode.Identifier
	pushq	$4 # visit ExpressionNode.Int
	popq	%r10
	popq	%rax
	addq	%r10, %rax
	pushq	%rax
	popq	%rdi
	callq	printint
	addq	$16, %rsp
	pushq	%rax
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	movq	-24(%rbp), %rdx
	movq	-32(%rbp), %rcx
	movq	-40(%rbp), %r8
	movq	-48(%rbp), %r9
	popq	_c(%rip)
# visit DeclarationNode.VariableDeclaration
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
# visit ExpressionNode.Negate
# visit ExpressionNode.Subtract
	pushq	$9 # visit ExpressionNode.Int
	pushq	$5 # visit ExpressionNode.Int
	popq	%r10
	popq	%rax
	subq	%r10, %rax
	pushq	%rax
	popq	%r10
	negq	%r10
	pushq	%r10
	popq	%rdi
	callq	printint
	addq	$16, %rsp
	pushq	%rax
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	movq	-24(%rbp), %rdx
	movq	-32(%rbp), %rcx
	movq	-40(%rbp), %r8
	movq	-48(%rbp), %r9
	popq	_d(%rip)
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
# visit ExpressionNode.Add
# visit ExpressionNode.Subtract
	pushq	$5 # visit ExpressionNode.Int
# visit ExpressionNode.Multiply
	pushq	$2 # visit ExpressionNode.Int
	pushq	$3 # visit ExpressionNode.Int
	popq	%r10
	popq	%rax
	imul	%r10
	pushq	%rax
	popq	%r10
	popq	%rax
	subq	%r10, %rax
	pushq	%rax
	pushq	$1 # visit ExpressionNode.Int
	popq	%r10
	popq	%rax
	addq	%r10, %rax
	pushq	%rax
	popq	%rdi
	callq	printint
	addq	$16, %rsp
	pushq	%rax
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	movq	-24(%rbp), %rdx
	movq	-32(%rbp), %rcx
	movq	-40(%rbp), %r8
	movq	-48(%rbp), %r9
	popq	%rax
	leave
	ret
.globl main
main:
	pushq	%rbp
	movq	%rsp, %rbp
	callq	start
	leave
	ret
