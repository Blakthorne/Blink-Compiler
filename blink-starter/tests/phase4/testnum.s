# visit StartNode
.data
	.comm	_x, 8, 4
	.comm	_first, 8, 4

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
# visit DeclarationNode.VariableDeclaration
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
	pushq	$1 # visit ExpressionNode.Int
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
# visit StatementNode.If
# visit ExpressionNode.Equal
	pushq	_x(%rip) # visit ExpressionNode.Identifier
	pushq	$0 # visit ExpressionNode.Int
	popq	%r10
	popq	%r11
	movq	$0, %rax
	cmpq	%r10, %r11
	sete	%al
	pushq	%rax
	popq	%r10
	cmpq	$1, %r10
	je	._ifTrue1
	jmp	._ifFalse1
._ifTrue1:
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
# visit ExpressionNode.Add
	pushq	$9 # visit ExpressionNode.Int
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
	pushq	$0 # visit ExpressionNode.Int
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
	jmp	._ifEnd1
._ifFalse1:
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
# visit ExpressionNode.Add
	pushq	$10 # visit ExpressionNode.Int
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
# visit ExpressionNode.Negate
	pushq	$1 # visit ExpressionNode.Int
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
._ifEnd1:
._ifEnd0:
	popq	_first(%rip)
# visit ExpressionNode.Method
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	%rdx, -24(%rbp)
	movq	%rcx, -32(%rbp)
	movq	%r8, -40(%rbp)
	movq	%r9, -48(%rbp)
	subq	$16, %rsp
	pushq	$9 # visit ExpressionNode.Int
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
