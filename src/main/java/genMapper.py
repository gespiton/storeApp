fields = '''    private String name;
    private String serialCode;
    private Double weight;
    private Integer stockNumber;
    private Integer preSaleNumber;
    private String shop;
    private Double introducedPrice;
    private Double marketPrice;
    private Double bankPrice;
    private Integer exchangeCredit;
    private String categoryName;
    private String brandName;
    private String onMarketTime;
    private String outMarketTime;
    private String addedTime;
    private String lastModifiedTime;
    private String description;
    private String imageNumber;
    private Boolean isDividable;
    private String defaultExpress;'''

fieldLi = [s.strip().split(' ')[1:] for s in fields.strip().split(';')[:-1]]

s1 = "("
s2 = 'VALUES ('
s3 = ''
for field in fieldLi:
    s1 += field[1] + ','
    s2 += "#{%s}," % field[1]
    s3 += '''@Param("%s") %s %s,''' % (field[1], field[0], field[1])

print(s1[:-1] + ')' + s2[:-1] + ')', s3[:-1], sep='\n\n\n')
