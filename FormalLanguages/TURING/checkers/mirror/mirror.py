
out = open("mirror.out", "w")
print("""start: s
accept: ac
reject: rj
blank: _   
s 0 -> s 0 >
s 1 -> s 1 >
s _ -> go _ <
go 0 -> wz zero >
go 1 -> wo one >
go _ -> go _ <
wz 0 -> wz 0 >
wz 1 -> wz 1 >
wz zero -> wz zero >
wz one -> wz one >
wz _ -> go_back 0 <
wo 0 -> wo 0 >
wo 1 -> wo 1 >
wo zero -> wo zero >
wo one -> wo one >
wo _ -> go_back 1 <
go_back 0 -> go_back 0 <
go_back 1 -> go_back 1 <
go_back zero -> find zero <
go_back one -> find one <
go_back _ -> do _ <
find 0 -> go 0 ^
find 1 -> go 1 ^
find zero -> find zero <
find one -> find one <
find _ -> do _ >
do 0 -> done 0 <
do 1 -> done 1 <
do zero -> do 0 >
do one -> do 1 >
do _ -> done _ <
done 0 -> done 0 <
done 1 -> done 1 <
done _ -> ac _ >""", file = out)