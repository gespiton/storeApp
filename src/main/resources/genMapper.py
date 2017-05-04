fields = '''
    private Long goodsID;
    private Double midUserPrice;
    private Double marketPrice;
    private Double realPrice;
    private String onMarketTime;
    private String offMarketTime;
    private Long preSaleCount;
    '''


def insert():
    global s1, s2
    fieldLi = [s.strip().split(' ')[1:] for s in fields.strip().split(';')[:-1]]
    s1 = "("
    s2 = 'VALUES ('
    s3 = ''
    for field in fieldLi:
        s1 += field[1] + ','
        s2 += "#{%s}," % field[1]
    print(s1[:-1] + ')' + s2[:-1] + ')', sep='\n\n\n')


def resultMap():
    fieldLi = [s.strip().split(' ')[-1] for s in fields.strip().split(';')[:-1]]
    li = ['''<result column="%s" property="%s"/>''' % (s, s) for s in fieldLi]
    print('\n'.join(li))


def update():
    fieldLi = [s.strip().split(' ')[-1] for s in fields.strip().split(';')[:-1]]
    li = ["%s = #{%s}," % (s, s) for s in fieldLi]
    print ('\n'.join(li))


# resultMap()
# insert()
update()