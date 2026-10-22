# Flags para o compilador
CFLAGS=-Wall -W -Wmissing-prototypes -g -Werror=vla

# nome do executavel 
PROGRAM=lab1

# Lista de objectos necessarios para criar o executavel
PROGRAM_OBJS=main.o sorter.o

.PHONY: clean

all: ${PROGRAM}

${PROGRAM}: ${PROGRAM_OBJS}
	${CC} -o $@ ${PROGRAM_OBJS} ${LIBS}

# Dependencias 
main.o: main.c sorter.h
sorter.o: sorter.c sorter.h

#como compilar .o a partir de .c
.c.o:
	${CC} ${CFLAGS} -c $<

clean:
	rm -f *.o core.* *~ ${PROGRAM} *.bak
