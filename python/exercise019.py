def is_leap_year(year):
    if year % 400 == 0:
        return True
    if year % 100 == 0:
        return False
    if year % 4 == 0:
        return True
    return False


def lear_year_day(month, year):
    if month == 1 and is_leap_year(year):
        return 1
    return 0


count = 0
dayMonth = 1
dayWeek = 0
month = 0
year = 1900

monthsLimit = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

for i in range(1,1_000_000):
    if dayWeek == 6 and dayMonth == 1 and 1901 <= year <= 2000:
        count = count + 1

    dayWeek = (dayWeek + 1) % 7
    limit = monthsLimit[month]
    dayMonth = dayMonth + 1
    if dayMonth > limit + lear_year_day(month, year):
        dayMonth = 1
        month = month + 1
        if month == 12:
            month = 0
            year = year + 1
    if year == 2001:
        break

print(count)