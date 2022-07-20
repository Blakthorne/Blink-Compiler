# visit StartNode
.data
	.comm	_x, 8, 4

.text

# visit DeclarationNode.MethodDeclaration
.globl start
start:
	pushq	%rbp
	movq	%rsp, %rbp
	subq	$48, %rsp
# visit DeclarationNode.VariableDeclaration
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
	popq	%rdi
	callq	readint
	addq	$16, %rsp
	pushq	%rax
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	movq	-24(%rbp), %rdx
	movq	-32(%rbp), %rcx
	movq	-40(%rbp), %r8
	movq	-48(%rbp), %r9
	popq	_x(%rip)
# visit StatementNode.If
# visit ExpressionNode.Greater
	pushq	_x(%rip) # visit ExpressionNode.Identifier
	pushq	$0 # visit ExpressionNode.Int
	popq	%r10
	popq	%r11
	movq	$0, %rax
	cmpq	%r10, %r11
	setg	%al
	andq	$1, %rax
	pushq	%rax
	popq	%r10
	cmpq	$1, %r10
	je	._ifTrue0
	jmp	._ifFalse0
._ifTrue0:
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
# visit ExpressionNode.Subtract
	pushq	_x(%rip) # visit ExpressionNode.Identifier
	pushq	$1 # visit ExpressionNode.Int
	popq	%r10
	popq	%rax
	subq	%r10, %rax
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
	jmp	._ifEnd0
._ifFalse0:
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
	pushq	$999 # visit ExpressionNode.Int
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
._ifEnd0:
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
