#quu..__
# $$$b  `---.__
#  "$$b        `--.                          ___.---uuudP
#   `$$b           `.__.------.__     __.---'      $$$$"              .
#     "$b          -'            `-.-'            $$$"              .'|
#       ".                                       d$"             _.'  |
#         `.   /                              ..."             .'     |
#           `./                           ..::-'            _.'       |
#            /                         .:::-'            .-'         .'
#           :                          ::''\          _.'            |
#          .' .-.             .-.           `.      .'               |
#          : /'$$|           .@"$\           `.   .'              _.-'
#         .'|$u$$|          |$$,$$|           |  <            _.-'
#         | `:$$:'          :$$$$$:           `.  `.       .-'
#         :                  `"--'             |    `-.     \
#        :##.       ==             .###.       `.      `.    `\
#        |##:                      :###:        |        >     >
#        |#'     `..'`..'          `###'        x:      /     /
#         \                                   xXX|     /    ./
#          \                                xXXX'|    /   ./
#          /`-.                                  `.  /   /
#         :    `-  ...........,                   | /  .'
#         |         ``:::::::'       .            |<    `.
#         |             ```          |           x| \ `.:``.
#         |                         .'    /'   xXX|  `:`M`M':.
#         |    |                    ;    /:' xXXX'|  -'MMMMM:'
#         `.  .'                   :    /:'       |-'MMMM.-'
#          |  |                   .'   /'        .'MMM.-'
#          `'`'                   :  ,'          |MMM<
#            |                     `'            |tbap\
#             \                                  :MM.-'
#              \                 |              .''
#               \.               `.            /
#                /     .:::::::.. :           /
#               |     .:::::::::::`.         /
#               |   .:::------------\       /
#              /   .''               >::'  /
#              `',:                 :    .'
#                                    
.comm _d , 4, 4 
.global main 
main:
jmp start
meth2:
enter $8,$0 
movl $0, -4(%ebp)
movl $0, -8(%ebp)
pushl 8(%ebp)
#ID 
pushl 12(%ebp)
#ID 
popl %ebx
popl %eax
addl %ebx, %eax 
pushl %eax
#ADD 
popl %eax
movl %eax, -4(%ebp)
#assign
pushl $10 
popl %eax
movl %eax, 8(%ebp)
#assign
pushl 8(%ebp)
#ID 
call writeint 
addl $4, %esp
#call good luck 
pushl 12(%ebp)
#ID 
call writeint 
addl $4, %esp
#call good luck 
pushl -8(%ebp)
#ID 
call writeint 
addl $4, %esp
#call good luck 
movl -4(%ebp), %eax 
leave
ret
#MethDef 
meth1:
enter $8,$0 
movl $0, -4(%ebp)
movl $0, -8(%ebp)
pushl $-5 
popl %eax
movl %eax, _d 
#assign
pushl _d 
#ID 
pushl 8(%ebp)
#ID 
pushl 12(%ebp)
#ID 
popl %ebx
popl %eax
addl %ebx, %eax 
pushl %eax
#ADD 
call meth2 
addl $8, %esp
pushl %eax 
#methexpr good luck 
popl %eax
movl %eax, -4(%ebp)
#assign
pushl 8(%ebp)
#ID 
call writeint 
addl $4, %esp
#call good luck 
pushl 12(%ebp)
#ID 
call writeint 
addl $4, %esp
#call good luck 
movl -4(%ebp), %eax 
leave
ret
#MethDef 
start:
enter $12,$0 
movl $0, -4(%ebp)
movl $0, -8(%ebp)
movl $0, -12(%ebp)
pushl $10 
popl %eax
movl %eax, -8(%ebp)
#assign
pushl $20 
popl %eax
movl %eax, -12(%ebp)
#assign
pushl -4(%ebp)
#ID 
call writeint 
addl $4, %esp
#call good luck 
pushl -8(%ebp)
#ID 
call writeint 
addl $4, %esp
#call good luck 
pushl -12(%ebp)
#ID 
call writeint 
addl $4, %esp
#call good luck 
pushl _d 
#ID 
call writeint 
addl $4, %esp
#call good luck 
pushl -12(%ebp)
#ID 
pushl -8(%ebp)
#ID 
call meth1 
addl $8, %esp
pushl %eax 
#methexpr good luck 
popl %eax
movl %eax, -4(%ebp)
#assign
pushl _d 
#ID 
call writeint 
addl $4, %esp
#call good luck 
pushl -4(%ebp)
#ID 
call writeint 
addl $4, %esp
#call good luck 
movl -4(%ebp), %eax 
leave
ret
#MethDef 
