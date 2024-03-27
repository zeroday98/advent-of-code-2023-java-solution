package solution.adventofcode;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AdventOfCode4_2 {
    static String input = """
            Card   1: 18 39  5 97 33 74 70 35 40 72 | 62 23 33 94 18  5 91 74 86 88 82 72 51 39 95 35 44 87 65 15 46 10  3  2 84
            Card   2: 58 50 13 61 80 48 99 86 45 31 | 61 32 19  6 72 31 52 79 93 45 85 67 56 80  8  9 60 42 73 17 99 13 58 92 50
            Card   3: 65 10 18 47  8  4 99 51 71 48 | 85 87 88  8 48 18 47 67 95  4 99 86 53 51 65 44 61 10 28 14 77 71 21 58 42
            Card   4: 22 99 16 18 81  3 62 43  2 42 |  8 55 39 83 29 10 87 27 25 70 19 30 80 12  1 41 85 14 34 82 90 76  5 89 15
            Card   5: 23 45 94 25 59 75 22 97 62 57 | 75 87 97 22  5 74 99 42 92 57 66 55 89 56 71 30 25 90 35 20 23 62 59 65 16
            Card   6:  6 56 78  8 89 70 97 91 31 75 | 86  3 75 21 43  8 97  6 19 23 70 78 92 25 91 89 45 31 83 58 79 32 67 56 50
            Card   7:  7 94 92 91 83 16 56 45 46 98 | 85 51  5 60 80 71 10 19 99 26 48 17 38  6 28 86 75 21 63 59 76 70 12 24 25
            Card   8: 42 44 48 75 49 35 56 21 89 18 | 15 39 88 74 95 72 94  9 93 22 83 85 63 16 62 61 34 24 90 41 47 38 68 66 13
            Card   9: 43 45  1  3 29 75 98 61 11 37 | 59  4 82 11 94 37 85 61 42 49 89 65  6 57 93 51 98 35 78 13  1 32 88 77  8
            Card  10: 49 90  6 30 33 86 19 56 41 95 | 53 52 19 43 50 54 73 41 66 49 10 86 48 27 32 16 13 95 64 79 51 90 38 47 55
            Card  11: 96 42 79  3 36  4 76 13 45 15 |  7  1 48  9 62 73 88 29 76 39 36 59 80 14 58 82 56 64 53  3 60 10 15 40 38
            Card  12: 13 39 45 96 17 88 67 46 74 11 | 37 33 26 97 75 46 54 86  8 94 71 89 99 91 64 15 52 16 50 60 27 76 22 66 31
            Card  13: 35 65 29 46 96 73 47 90  8 79 | 21 76 19 30  6 42 51  1 82 69 58 45 72 15 70 89 60 91 49  7 12 50  4 83 43
            Card  14: 28 42 50 49  6 60 55 61  2 48 | 96 42 57 70  4 86 98 67 73 43 26 89 65 99 11 46 84 16 68  8 87 93 97 79 14
            Card  15: 93 97 71 21  8 90 64 11 16 12 | 44 55 86  2 45 14 88 47 74 49 67 43  5 15 58 82 57 73 98  1 23 21 38 89 60
            Card  16: 22 40 49 29 82 27 44 83 34 24 | 63 59 39 91  3 14 66 81 42 19 80 98 61 67 84 73 53  1 36 77 20 78 70 13 96
            Card  17: 48  4 67 20 70 63 68 41 60  6 | 98 32 84 78 27 29 30 56 72 31 38 21 83 36 59 62 49 34 44 17 42 11 96 86  3
            Card  18: 28 41  8 45 72 99 80 82 90  2 |  5 65 49 13  9 60 36 96 88 87 42 86 19 15 92 16 43 67 73 81 17 24 72 48 35
            Card  19: 91 50 36 74 41 17 92 55 59  3 | 17 43 23 10 15 41 91 40 46 36  3  8 45 22 55 71 14 92 74 61 59 95 57 50 35
            Card  20: 90 49 57 48 10 74 70 46 56 39 | 22 84 10  2 39 46 91 14 48  1 28 70 43 56 21 16 57 49 90 85 74 36 83 86 11
            Card  21: 90 95 32 48 56 51 24 85 15 42 | 76 71 48 91 60 32 19 24 75 36 56 42 90 51 95 53 47 18 85 34 45 87 35 15  3
            Card  22: 76 99 28 36 61 50 17 43 69 23 | 87 12 62 50 34 61 36 74 22 99  6 17 60 54  2 56 38 28 67 78 71 75 13 89 76
            Card  23: 41 12 48  2 93 94 95 27 19 62 | 93 21 27  2  6 40 95 45 54 75 52 53 85 78 12 41 48 94 61 18 65 87 69 55 86
            Card  24:  7 54 91 12 47 29 14 73 53 44 | 95 76 54 24 68 57 59 58  7 10  3 62 88 37  6 28 53 55 74 29  8  9 99 56 16
            Card  25: 78 95  5 23 99 27  6 81 65 38 | 95 77 96 33 51  4 91 45 75 30 24 37 38 73 58 31  1 48 59 78 26  7 36 41  5
            Card  26: 86 51 73 94 39 83 53 37 95 26 | 24 61 57 28 91 53 35 42 86 81 85 74 88 45  5 18 26 76 83  7 84 25 54 93 98
            Card  27: 10 27 16 98 48 21 54 49 50 30 | 73 84 90 53 40 93 70 80 57 63 74 18 87 15 60 67 49 28 17 22 69 58  1 46 48
            Card  28: 26 54 35 22 87  3 79 25 43 36 | 30 86 57 37 28 68 64 78 75 11 89 65 97 82 72 95 24 61 53 27 99 76 63 31 34
            Card  29: 84 26 15 79 13 39  7 42 24 63 | 55 20 38 83 67 43 78 92 23 19 12 80 98 49 61 75 74 50 39  3 58 26 45 31 25
            Card  30: 82  5 53 96 32 86 37 99 21 64 | 59 30 64 78  4 19 74 71 61 98 10 93 46 84 63 26 43 60 52 16 33  1 22 80 57
            Card  31: 88  4 65 44 96 56 30 19 41 17 | 46 74 33 48 18 89 92 80 13 21 64 86 12 70 69  4 72 75 68 50 91 23 61  5 25
            Card  32: 83  2 55 39 34 14 46 68 23  9 | 85 94 95 99 48 59 79 74 38 43 50 17 56 78 66 61 88 96 22 19 65 24 27 52 98
            Card  33: 66 46 28 74 29 96 21 24 53 33 | 28 53 80 66 57  1  2 65 24 96 79  3 23 29 46 33 50 74  8 89 16 88 21 38 48
            Card  34: 30 33 90 82 27 77 47 72 80 79 | 73 65 87 50 61 77 27 66 32 70 25 31 33 47 44 39 90 91 22 78 29 54 82 69  3
            Card  35: 42 39 79 78  7 99 29 96 21 49 | 33 39 19 87  6 91 52 96 79 78  7 99 49 22 73 74 42  4 29 21 64 10 97 95 66
            Card  36:  5 73 43 92 21 13 48 55  1 42 | 54 29 70 99 42 79 12 77 92  1  3 32 24 16 28  2 88 68 62  8 30 15 98 36 59
            Card  37: 38 10 59 67 82 52 80 85 77  4 | 45 38 47 85 82 36  4 21 12 59 27 62 52 44 10 30 94 31 75 77 74 33  8 80 67
            Card  38: 72 94 25 22 91  8  1 81  3 18 |  3 94 33 37 25 72 47 70 24 81 16 96 55 26 80 79 40  8 11 18 30 91  1 22 61
            Card  39: 95 76 34 53 17 40 72 94 52 23 | 12 99 47 44 85  2 52 94 95 10 70 75 38 76 91 97  6 23 37 53 17 34 40 72 20
            Card  40:  3 42 58 56 81 55 32 73 59 57 | 42 73 84 64 57 69 59 91 61 65 56  7  3 55 18 58 16 68 23 71 45 79 81 82 32
            Card  41: 82 59 74 61 44  8 68 70  7 50 | 13  1 26 90 49 92 59  2  7 56 72 71  5 52 45 48 73 79 82 32 94 63 37  6 98
            Card  42:  8 56 68 19 69 63 49  6 92 16 | 31 89 58 41 49 35 19 85 52 60 77 61 47  9 81 63 37 99 21 33 20 68 56 79 29
            Card  43: 76 23 38 67 82 13 88 72 92 90 | 59 23 39 13 93 35 47 38 97 12 15 89 88 31 28 83 82 74 42  3 86 46 37 92 43
            Card  44: 91 29 78 64 12 48 39  7 50 33 | 73 14 11 71 70 97 13 80 20  5 42 24 98  9 55 32 10 15 40 67 93 49 99 69 65
            Card  45: 32  3 87 51 83 85 50 59 40 95 | 55 88 78 41  8  2 21 11 65 37  1 51 20 47 82 12 44 28 69 49 95 46 14 48 97
            Card  46: 14 99 84  7 88 77 70 10 96 20 | 45 84 97 32 55 16 89 54 85 19 58 36 14 99 72 70 35  6 27  7 77 20 87 64 10
            Card  47: 90 54 46 43 99 33 40 16 32 79 | 86 79 38 78 62 39 72 87 82 37 43 34 76 22 57 33 58 28 46 21 60 89 23 14 99
            Card  48: 67 51 13 31 59  9 79 74 37 93 | 98 33 63 44 99 90 83 55 19 77 34  9 67  4 28 41 31 57 76 93 64 65 69 18 17
            Card  49: 85 56 10 17 44 73 66 28 29 65 |  3 78 68 80 67 93 30 39 40 73 90 92 96 19 51 75 33 45 55  2 71 50 10 74 28
            Card  50: 10 77 11 97  9 61 73 76  1 48 |  6 71 88 15 99 84 66 94 76 24 27 29 95 14 89  9 36 91 12 79 67  2 56 53 38
            Card  51: 61 53  5 74 98 25 89  2 56 23 | 43 92 71 14 28 83 22 84  7 31 64 54 55 38 90 85 42 16 47 63 45 50 35 76 96
            Card  52:  9 48 70 88 83 54 23 24 92  2 |  1 64 44 47 15 74 63 55 13 53 78 24 17 30 91 89 60 21 45  7 33  5 87 68 22
            Card  53: 47 71 11 88 31 61 69 29 76 81 | 14 93 73 98 39 81 23 66 62 51  8 42  2  7 36 69 54 79  4 46 65  3 59 26 78
            Card  54: 23 79 67 69 68 31 30 82 28 99 | 19 81 80 54 17  5 58 29 16 52 85 33 47 14 55 46 53  1 66  6 75 62 36 37 12
            Card  55: 35 26 72 67 62 76 98 37 80 85 | 53 63 48  3 49 59 38 65 83 97 44 13 18 36 22  6  7 27 82  2 42 33 56 64 54
            Card  56: 12 95 30 57 67 31  4 45 70 89 | 93  1 67 98 95 76 23 19 48 77 74 12 31 21 45 73  4 39 22 30 88  2 89 57 18
            Card  57: 55 83 72 27 42 20 56 14 98 49 | 55 41 17 42 13 64 98 72 63 30 83  4 49 20 22 27 69 18 56 87 38 97  9 14 26
            Card  58: 86 22 83 61 13 67 53 56  1 18 | 72 65 28 43 64 18 70 54 45 78 68  6 44 47 91 58 73 14  7 36 41 98 92 86  5
            Card  59: 16 35 26 51 39  7 13 71  3 57 | 10 89  3 96 85 17 63 95  6 86 13 25 26 24 39 35  7 61 57 56 12 71 16 69 51
            Card  60: 88 99 24 72 49 53 94 64 12 17 | 53 79 63 45 77 48 86 51 17 19 57 37 69 64 11 47  4 91 43 82 39 92 31  8  1
            Card  61: 32 98 33 94 16  8 86 61 11  7 | 56 24 63  8 62 46 49 85 96 22 51 98 25 66 83 43 18 33 86 48 36 55 54 78 32
            Card  62: 86 89 12 58 63 55 79 85 30 98 | 67 29 49 86 78 12 96 23 74 46 22 26 85 63 44 10 52 11 91 70 89 54 37 41 40
            Card  63:  8 20 73 62 48 65 16 44 77 53 | 87  5 69 20 39 16  7  8 78 65 19 27 61 13 73 40 22 46 12 14 71 48 77 89 41
            Card  64: 70 58 28 95 75 34 83 93 71 87 | 36 79 44 46 60 98 96 12 47 27 52 68  4 45 35 19 77 67 56 20 13 73  3 91 21
            Card  65: 17 60 35 31 36 46 65 74 42 20 | 20 99 54 92 32  4 60 70 25 87 79 14 65 28 86 94 98  1 95  2 84 46 10 39 19
            Card  66: 40  1 58  7 68 71 13 63 27 57 | 77 51  9 54 94 58 74 12 52 11 49 45 22 34 18 41 32 64 79 10 43 39 90  4 20
            Card  67: 85 10 94 63 59 46 30 24 32 77 |  6  9 23 13 24 74  7 73 82 84 29 55 61 33 67 59 98 14 10 72 83 40 89 78 44
            Card  68: 91 57 42 58  8 64 30 32 52 94 | 73 41 82 15 62 30 95 71 77  4 40 57 54 69 36 14 26 45 68 56 70 35 79 86 72
            Card  69: 62 66 16 28 77 35 36 92 53 45 | 16  4  3 83 88 32 62 29 30 31 93 49 91 22 41 63 89 55 14 67 24 75 19 43 39
            Card  70: 86 54 56 72 25 80  6 90 81 19 | 39 69 21 78 83 76 95 90 16 59 30 77  3 17 89 45 96 82 52 14 97  1 49 32 68
            Card  71: 17 46 34 60 95 96 29 43 21 38 | 28 85 19 90 24 21 64 87 23 98 48 80 45 15 88 32 67 49 94 42  2 26 84 73  8
            Card  72: 30  8 93 19  6 14 91 70 60 90 | 27 59 96 25 73 64 74 69 75 21 56 80  1 63 41 95  5 86 97 20 58 87 78  4 53
            Card  73: 82 38 40  6 10  9 84 61  8 52 |  8 10  3  6 42 38 52 84 40 59 61 93 82 96 12  9 50 14 31 30 29 48 63 79 44
            Card  74: 47 26 10 74 45 37 38 83 78 34 | 26 27 94 66 83 33 42 73 34 72 37 81 36  8 68 38 78 45 93 48 10 47 90 16 74
            Card  75: 15 74 14 45 46 38 55 33  1 43 | 21 80 90 10  9 23 81 72 73 15 89 92  5 55 40 44 64 49 50  4 41  8 39 53 27
            Card  76: 92 51 94 66 82 46 84 11 34 20 | 20 83 32  3  9 92 49 39 31 15 21 26 94 84 46 99 82 66 30 16 80 34  1 11 78
            Card  77: 38 23 79 47  8 12 19 96 27  7 | 27 28  7 73 98 95 17 72 69 79 96 50 41 12 52 20  9 89 90 23  1  8 11 38 19
            Card  78: 58 56 84 74 47 60 34  9 85 12 | 60 61 40 98 12 16 49 95 96 24 62 58 79 28  8 50 20 48 34 55 31  9 47 92 74
            Card  79: 90 46 71 76 37 77 81 98 41 21 | 46  8 81 27 62 77 37 10 53 29 76 71  4 72 86 98 42  6 41 17 92 90 74 65 21
            Card  80: 37 34 29 49 45 24 50 64 88 22 | 21 64 44 27 69 45 91 63 24 58 95 49  2 37 29 51 89 22 79 34 50 39 35 60 14
            Card  81: 18 73 86 57 72 49  4 71 24 31 | 22 49 93 72 44 35 24 71 52 57 39  4 36 31 19 15 73 94 18 10 78 27 33 67 86
            Card  82: 63 20 33 16 84 17 48 22 81  1 |  3 85 71 20 66 63  9 57 39 36 86 30 98 33  2 78 65 56 80 88 10 64 12 76 87
            Card  83: 93 44 99 94 85 23 65 10  8 34 | 87 96 44 41 34 33  6 36 80 93 99  8  7 74 66 42 81 94 10 29 53 85 51 22 65
            Card  84: 83 38 69 13 95 37 56 58 33  9 | 66 27 18  6 47 37 58 13  7 34 33 82 99 15 42 69 83 11 38  9 64  3 84 95 56
            Card  85: 96 75 30 19 74 78 28 86 13 32 | 45 74 40 96 39 30 51 86 41 81 13 61 91  2 75 11 20 64 57 67 44 19  4 32 62
            Card  86:  4 35 56 97 19 68 90 44  1 57 | 23 12 63 47 94 51 87 69 26 43 66  2 25 14 65 80 89 56 60 95 27 17 77  7 16
            Card  87: 72 83 55 35 37 31 57 67 78  3 | 27 25 71  6 47 37 79 57 98 81 69 61 97 83  2 90 29 24 54 80 39 34 78  8 11
            Card  88: 78 68 10 53 86 67 98 62 77 99 | 96 71 14 65 98 34 31 74 41 76 82 70 58 60 44 32 42 20 85 69 73 35 17 40 99
            Card  89: 78 37 96 71 15 13 69 63 72 20 | 63 14 11 96 10 76 20 28 99 72 45 83 85 81 17  3 15 40 25 33 79 90 94 61 64
            Card  90: 76 62 47 94 72 86 80 70 67 49 | 46 92 50 28 22 18 81 58 61  3 21 77 60 31 57 59 39 44 83 24 66 23 34 10 85
            Card  91: 20 52 30 27 55 26 72 85 57 86 | 56 94 18 52  6 55 40 30 97 10 14 78 54 53 48 38  2 43 73 75 95 17 36 87 91
            Card  92:  4 70 11 49 55 93 75 66 51 18 | 43 19 74 60  2 64 93 76 63  4 67 90 45 18 96 27 97 89 86 70 82 23 20 94 88
            Card  93: 58 26 70  8 95 65 51 29 88 19 | 43 89 80 61 60 42 75 56 68  6 74 24 15 81 86 94 11 30 53 95 35 40  7 27  3
            Card  94: 91 55 92 45 62 82 63 75 28 30 | 27 43 22 44 55  5 71  1 54 40 67 72 33  6 15 49 34 13 59 61 88 97 99 73 29
            Card  95: 96 39 90 73 80 31 60 41 58 52 | 85 68 51 56 61  3 21 16 31 40  6 34 25 63 88 44 97 38 66 94 13 72 15 12 81
            Card  96: 33  2 11  8 19 54 18 17 95 60 | 94 68 72 86 78 55 28  4 12  7 35 30  6 69 25 81 76 88 99 51 98 41 34  9 93
            Card  97:  7 20  1 39  9 24 29 50 51 22 | 44 73 61 90  3 34  5 72 95 52 33 32 53 77 56 43 39 58 74 38  1 41 98 42 24
            Card  98: 88 55 58 42 34 33 24  8 18  3 |  7 95 68 31 60 99 53 51 18 22 69 12 13 33 23 76 58 59 35 48 11 16 66  9  3
            Card  99: 31 47 15 27 68 72 90 21 29 55 | 64 46 83 79 35 90  5 58 34 77 59 75 27 11 96 29 21 18 72 32 68 31 97 37 36
            Card 100: 47 79 18 44 28 25 86 43 39 95 | 75 92 95 88 32 98 78 36 33 15 51 79  1 25 89 43  2 52 80 12 28 63 18 16 41
            Card 101: 14 13  2 61 57 25 90 68 60 62 | 50 51  1 71 62 68 40 92 34 41 30 13 17 12  4 52 84 70 49 26 74  6 37  2  8
            Card 102:  4 83 67 27 41 55 44 24 63 40 | 76 81 44 17 73 40 62 51 83 77 75  6 86 47 36 97 90 23 41 55  4 98  3 52 26
            Card 103: 48 69 30 49 23 71 10 46 68 67 | 63 69 20 65 86 98 22 11 95 41 10 79 85 76 78 34 32 26  5 97 89 51 62 56 46
            Card 104: 94 52 85 89 84  6 50 74 14  7 | 96 68 74 80 54 47 73 48 89 52 35 21 26 94 13  7 81 65 36 34 76 84 95 86  6
            Card 105: 43 79 12 95 31 55 71 42 26 69 | 96 28 93 34  2 37 72 29 99  3 18 89 54 86 24  6 60 14 53 68 61 48 73 12 87
            Card 106: 46 50 45 27 14 57 68  5 58 99 |  5 24 46 62 38 99 58 20  2 15 26 27 96 71 48 17 39 47 52 29 60 93 97 11 90
            Card 107: 64 75 46  4 35 77 30 72 50 37 | 11 76 83 24 61 12 55 60 99 44 18 67 38 71  3 52 36 65 84 50 16 90  4 89 78
            Card 108: 37 75 45  3 49 25 41 66 53 69 | 37 44 88 63 27 67 47 50 12 30 19 21 33 53 22 18 87 81  1 64 61 69 70 74 52
            Card 109: 47 61 56 43 27 97 80  4 48 57 | 10 75 18 69 80 32 94 99 23  5 79 57 60 29 62 46 77 82 68 35 42 15 40 45 13
            Card 110: 28 60 19 96 54 10 32  8 89 36 | 93 15 75 83 86 97 92 72 30 17 58 87 25 33 78 79 31 64 12 84 59 77 95 80 66
            Card 111:  6  3 96 50 47 95 67 85 23 28 | 18 81 60 12 13 48 38 76 59 52 80 84 31 19 43 36 37 24 20 70 88 58 30 94 61
            Card 112: 12 67 48 46 62 63 29 25 69 99 | 55 95 10 58 46 36 99 24 68 12 25 40 62  7  1 29 15 67 42 90 26 74 30 85  5
            Card 113: 37 63  8 84 91 90 44  6 71 14 |  1 28 32 83 71 14 43  3 12  5 45 77 37 84 63 64 44 61 21  8 91 16 90  6 80
            Card 114: 69 48 22 87 33 82 37 72 24 38 | 20 57 84 10 33 96 19 92 14 99 47 15 60 54 45 36 59 40 24 21 42 25 34 46 22
            Card 115: 75 65 97 13 10 42 89 91 54 18 | 42 75  6 96 18 52 29 97 68 65 79 54 88 45 61 63 13 10 21 74 15 91 89 48 99
            Card 116: 40 38 70 96 64 63 18 84 80 52 | 93 81 29 78 70 64 91 52 38 63 46 65 96 67 92 94 84 45 53 33 44 18 22 69 40
            Card 117: 30 36 87 98 59 85 60 67 69 40 | 83 59 67 16 85 69 23 47 95 18 89 64 36 19 92 60 75 52 48 98 34 46 87 40 30
            Card 118: 34 55 45  2 37 39 79 52 85 40 | 88 33 79 39 82 36 34 11 38 22 14 63 67 32 52 83 45 17  5 29 94 71 35 70 23
            Card 119: 54 64  6 16  4 92 95 68 21  9 | 84  4 29 76 92 95 67 61 98 64 22 52  8 63 16 56 32  9 15 69 81 75 66 46 68
            Card 120: 84 50 41 58 37 19 44 95 90  1 | 50 17 18 95 38  1 94 90 63 54 87 30 58 26 60 44 20 29  3 72 80 69 88 86 84
            Card 121: 62 48 42  2 23 14 69 85  5 10 | 65  5 13 59 32 41 54 35 72 73 57 80 29 43 98 21 14 97 87  9 81 11 10 70  2
            Card 122: 16 23 79 54 80 59 20 87  3 98 | 37 13 98 92 57  9 46 12  7 87 67  8 28 16  2 53 80 39 20 27 78 60 58 59 54
            Card 123: 93 42  8 55 50 21 76 78 73 82 | 20 32  4 48 10 65 83 37 26 31 87  9 33 99  3 17 43 27  7 38 77 34 46 52 75
            Card 124:  2 73 64 66 65 49 41 31 14 11 | 51 73 10 76 28 64  2 49 91 31 98 94 30 68 60 16 65 77 41 43 26 63  5  8 42
            Card 125: 51 25 30  6 95 66 47 56 40  9 | 44 33 11 59 32 46 54  8 20  2  1 52 93 60 53 78 34 23 51 43 92 15 65 88 36
            Card 126: 12 14 43 26 54 74 97 46 94 35 | 88 55 78 58  4 43 47 11  2 97 94 13  6 90 95 91 32 79 51 74 41 38 63 53 25
            Card 127: 89 79 66 27 59 52 48 85 53 75 | 48 89 11 72 62 85  5 78 36 13  2 96 53 60 55 34 38 21 42  1 82  9 97 75 32
            Card 128: 87 54 92 24 73 72 60 64 57 75 | 22 91 98 47 72 23 80 81 74  7 95 84 89 73 37 45 19 75 12 32 34 83 33 46 40
            Card 129: 94 75 61 45 66 28 41 48 97 36 | 26 89 88 71  6 69 85 22 10 40 39 15 53  4 28 92  3 95 33 18  5 43 77 84 68
            Card 130:  8 39 74  3 91 69 81 95 58 12 | 94 85 24 54 83 12 16 76 80 87 30 27 82  6 43 31 26 59 96  4 71 60 65 32 97
            Card 131: 75 60 86 88 82 45 61 52  5 72 | 93 25 11 41  7 20 35 13 63 67 47 29 65 98 62 81 58 21 16 37 84 68 57  6 92
            Card 132: 81 62 18 13 72 11 84 65 23 21 | 63 29 27 17 19 56 55  5 45 52 73 91 40 66 36 12 24 96 32 31 79  9 94 82 80
            Card 133: 77 68  6 70 76 51 86 52 94 12 | 50 17  6 53 28 58 52 90 81 76 12 68 77 47  8 92 70 78 15 56 51 23 94 86 89
            Card 134: 61 72 75 84 33 11 86 15 24 81 | 53 61 43 33 11 81 70 56  1 86 84 42 87 66 88 15 49 90 36 92 75 55 72 18 24
            Card 135: 80 82 12 48 95 40 18 98  3 66 | 84 22 33 92 62 71 87  5 74 91 21  9  6 66 28 93 54 56 80 53 16 64 68 72 98
            Card 136: 81 73 85  1 21 60 82 35 10 16 | 79 88 59 85 92 61 16 73  1 55 90 35 81 74 53 21 20 26 91 99 30 10 82 60 25
            Card 137: 13 72 81 36 93 71 67 19 94 25 | 83 21 23 41 89 65 47 73 39 67 27 33 29 38 74 51 63 77 26 68 22 98  9 66 78
            Card 138: 83  9 60 92 97 63 81 35  7 28 | 36 63 46 24 62 91  1 86 40 38 99 34 41 35 68 92 85 45 10 28  7  9 97 27 72
            Card 139: 38 82 12 60 72 33 65 55 21 70 | 30 56  6 14 12 60 70 50 38 55 63 48 72 21  4 25 61 37 39 82 65  2 13 68 33
            Card 140: 24 61 78 83  3 30 62 32 93 72 | 24 26 82 62 40 44 42 43 60 78 39 32 75 57 29 13 30 17 71 61 37 55 72 22  8
            Card 141: 32 51  4 66 29 56 70 35 36 44 | 38  6 67  2 80 13  8 15 48 82 50 28 23 76 58 20 62 90 24 32 60 77 97 72 37
            Card 142:  7 71 82 35  4 51  3 85 20 50 | 24 28 16 70 97 18 26 79  8  5 27 32 41 42 36 39 49  1 86 23 55 48 72 87 65
            Card 143: 86 79 20 64 92 73 89 31 47 78 | 20 36 74 21 70 29 14 92 78 65 67 12 22 31 35 24 51 97 45 42  7 48 15 28 82
            Card 144: 65 98 49 14 31 89 47 66 73 59 | 81 55  4 45  8 32 99 38 95 67 62 80 84  2  1 53 18 46  6 19 79  3 74 70 83
            Card 145: 58 68 79 56 16 95 54 87 19 20 | 41 74 46 96 32 79 26 22 66 60 73 18  1 23 56 38 14 54 78 68 70 11 27 62 82
            Card 146: 10 89 12 51 50 55 15 36 44 73 | 12 47 64 59 34 50  9 57 20 38 81 95 86 46 88 27 30 56 90 32 78 58 72 26 80
            Card 147: 20  3 86 21 50 62 22 37 98 78 | 32 26 50 78 79 91 93 81 94 76 85 88 33 40 34 84 55 68 53 80 64 83  4 70 46
            Card 148: 73 17 63 58 55 37 67  3 35  1 | 88 98  5 94 40 58 17 34 45 75 77 30 96  4 48 38 51 99 18 28  2 53 12 20 69
            Card 149: 57 30 31 85 94  5 65 81 35 50 | 17 19 59 90  3 23 87 49 18 89 30 26 56 24 32 83 39 44 33 69 20 64 76 71 27
            Card 150: 50 83 74 16  8 18 71 15 48 39 | 79 58 67 89 33 10 97 81 38 82 92 87 72 70 56 62 69 31  2 17 22 95  7 53 55
            Card 151:  2 44  6 14 99 84 35 91 54  1 | 90 45 80 16 35 51 84 54 86 33 79 47  4 11 85 92 95 15 61 12  6 91 29 32 94
            Card 152:  1 36 80  9 92 96 39 45 94 26 |  8 87 94 81 99 41 80 96 17 26 57 39 53  6 92 27 74 45  1 10 38 84  9 36 44
            Card 153: 79 41 13  7 73 95 17  8 47 28 | 34 79 30 95 41 28  8 87 33 13  6 51 39  7 73 97  3 21 59 60 48 47 81 10 17
            Card 154: 62 47 50 22 64 83 77 51 37 15 | 44 53 49 77 66 15 33 62 22 91 83 89 37 50  5 47 64 36 52 27 75 30 84 12 51
            Card 155: 96 11 95 56  1 91 99 31 17 76 | 48 22 96 76 14 95  1 11 39 92  8 56 35 74 99 71 12 24 85 10 31 17 49 72 91
            Card 156: 95 26 90 54 11 59 12 18 61 67 | 32 97 29 31 44 87 79 28 34 58 56 73 91  7 48 82 94 42  9 22 88 50 64  2 13
            Card 157: 59 53 48  7 61 16 18  2 86 22 | 15 55 86 39 85 42 16 22 48 12 18  1  9 24 54 82 40 31 26 79 66 59  2 75 61
            Card 158: 25 44 17 67 65 33 57 56 52 10 | 54 81 89 11 24 93 82  3 35 98 80 33  7 21 85 74 65 77 26 46 34 42 87 68 44
            Card 159: 54 22 66 99 48 10 58 75 87 94 | 12 16 21 74 87 58 20 22 10 96 54 90 48 67 11 94 75 52 49 15 76 99 26 34 66
            Card 160: 25 27  8 48 59 14 26 42 60 20 | 82 84  4 39 52 78 49  9 13  7 89 12 30 86 92 67 57 40 96 80 29 71 35 72 23
            Card 161: 77 58 25 78 10 89 18 90 14 30 | 67 11 31 13  6 68 23  4 85 88  3 70 97 56 35 29 74 17 96 32 83 16 71 41 45
            Card 162: 90 99 58 44 27  3 17 91 40 55 | 46 17 26 90 53 27 91 93 79 44 55 99 10 31 30 45 58 23 74 66 11 40 92  3 97
            Card 163: 81 56 26 18  2 38 82 94 55 19 | 68 25 44 18 55 85 29 39 64 67 40 62 48 95  2 84 69 63 82  8 87 66 47 72 93
            Card 164: 52 38  3 66 98 14 48 20  4 73 | 21 93 77 73 66 86 70 98 18 31 51 12 52 45 38  3 72 14 48 62 71 67 46 69  4
            Card 165: 99 34 98 92 45  2  4 11 26 75 | 57  5 65 37  1 10 42 98 77 34 94  7  4 66 21 92 38 83 26 75 49 78 79 25 52
            Card 166: 57 84 46 48  1 73  4  2 12 70 | 57 99 12 70 48 30 20 34  9 72 50 65 91 66 52 46 37 78  4 73 32  1 84 75 71
            Card 167: 29 20  7 63 39 51 25 15 62 60 | 60 44  5 32 10 99 53  6 33 42 98 94 62 83 12 29 24 54 20 13 73 79 61 14 45
            Card 168: 81 74 27 44 71 80 30 29 90 60 | 64  6 76 84 54 85 80 92 36 90 40 78 94 50 55  5 29 12 34 20 13 62 28 82 70
            Card 169: 42 48 39 85 46  3  1 55 33 70 | 90 30 50 31 95 88 80 46 53 39 15 89 51 76 48 33 97 28 75 63 38 72  1 17 47
            Card 170: 78 40 42 30 31 46 48 92 41 53 | 31 20 28 17 98 54  5  1 44 91 97 40 42 73 65 83  6 75 68 93 95 86 82 30 34
            Card 171: 30 54 32 34 69 29 88 81 84 60 | 62  7 39 59 64 80 14 77 10 85 46 38 69 63 30 81  5 33 89 72 87 70 43 17 98
            Card 172: 52 59 65 99 20 71 10 70 89 92 |  5 84 49 90 77 56 79 16 75 29 11 94 32 59 96 33 87 65 39 14  1 98  7 58 63
            Card 173: 13 83 77 47 66 22 90 15 56 27 | 13 86 82 35 23 34 45 53 67 88 74 85 75 16  4 87 48 83 64  8 17 89  6 70 12
            Card 174:  7 19 64 23 74 44  8 88 11 15 | 93 37 46 50 70 87 14 66  1 24 45  3 84 85 31 79  2 49 83 36 99 12  9 39 71
            Card 175: 95 59 37 26 89 35 54 79 91 70 | 23 55 96 44 14 98 81 10 82 32 78 43 72 25 62 31  1 51 30 24  4 33 63 76 93
            Card 176: 82 85 29 74 55 93 70  8 65 51 | 24 36 70 34 18 55 74 28 11 93 65 72 86 56 98 82 35 48 67 22 85  4 90 29  8
            Card 177: 10 67 13 30 97 26 50 60 90 11 | 10 60 67 50 65  9 45 97 17 90 29 26 30 20 71 54 13 11 25 74 49 28 59  1 22
            Card 178: 97  4 21 34 17 56 61 16 46 62 | 56 16 34 42 54 97 78 50 72 21 31 10 46 12 62 27 68 70 61 88 91 17  4 11 77
            Card 179: 37 14 25 29 77 12 57  9 11 56 |  4 56 18 44 37 27 42  6 82  9 25 50 52  1 14 26 12 39 57 87 29 11 98 47 77
            Card 180: 99  7 27 95 34 96 18 84 13 81 | 11 19 23 48 62 94 81 24 95 34 27 13 61 80 84 99 73 77 96 79 22 82 18  7 14
            Card 181: 21 78 27 22 23 42 31 13 88 32 | 57 59 68  7 24  4 83 98 81 36 41 20 21 44 45 51 66 65 46 73 60 62 52 16 26
            Card 182: 19 69 85 77  2 99 30 51 84 67 | 77 34 43 69 35 58  9 13 74 42 33 19 44 99 30 51 20 83 78 73 92 84 85 81 31
            Card 183:  5 53 84 22 88 55 72 76  2 60 | 16 55 77 76 72 83 52 84 69 87 88  9 35 60 85  2 53 43 63  5 58 67 56 26 22
            Card 184: 84 40 17 12 19 36 27 21 57 91 | 88 54 18 84 95 57 27 94 96 44 39 62 77 12 87 98 14 67 19 46 43 71 40 33 36
            Card 185: 55 16 42 78 53  7 33 14 34 27 | 51 96 13 61 82  9 34 35 94 14 60 15 85 87 90 92 37 41 99  1 16 81 58 36 53
            Card 186: 89 35 24 19 64 68 12 33 51 57 | 37 51 76 19 12 57 71 36  7 33 25 44  2 59 91 56  8 42 68 35 64 24 77 70 89
            Card 187: 13  3  5 21 32 14 68  7 52  8 | 28 55 17  7 18 76 68 74 20 44 30 94 52 54 67 81 31 84 75 29 32  4  8 45 43
            Card 188: 27 62 22 79  8 47 34 73 84  7 | 23 24 36 62 94 50 47 75 32 90 22 44 45 93 34 10 84 71 79 59 25  8 69 30 16
            Card 189:  2 66 50 43 23 47 41 78 51 36 | 53 37 17 90 32 40  6 20 10 72 77 89 70 61 95  4 21 50 85  8  9 34 52 24 92
            Card 190: 50 72 64 97 46 90 55 10 38 98 | 19 85 33 18 86 10 12 81  4 50  9 68 73 44 96 38 45 27 87 15 99 63  7 52 75
            Card 191: 18 38 73 48 19 66 10 79 80 89 | 40 91 88 41 80 77 71 83 68  6 27 37 74 84 11  8 50  7 20 54 48  9 23 21 16
            Card 192: 40 67 24 38 51 84 87 50 82  8 | 50 14 97 51 41 24  8 73 29 40 27 18 94 67 31 45  5 58 84 26 77 16 47 60 99
            Card 193: 68 13 32 37 43 48 10 24 90 60 | 25 90 96 92 57 15 11 97 83 54  4 17 20  8 26 39 50 94 40 71 76 43 55 67 98
            Card 194: 72  7  8 11  3 39 25  4 32 84 | 22 64 51 41 13  7 59 84 32 10 72 81 61 17 52 58 31 89 95 54  8 92 56 28 15
            Card 195: 95 18 43 83 12  8 13 54 71 80 | 27 41 56 65 84 99 74 57 25 38  4  1 66 77 86 11  5 58 47  8  6 55 68 40 85
            Card 196: 48 42 11 29  9 85 81 54 90  5 | 19 58 33 55 95 92 40  4  8 84 35 53 14 60 23 25 98 21  9 90 93 82 43 37 38
            Card 197: 85 88 32 15 25 54 79 27 90 82 | 77 32 41 70 76 68 71 10 67 31 64 92 42 74 58  7 18 65 99 93 50 38 63 45 82
            Card 198: 58 67 42 84 62  1 65 92 86 23 | 28 36 58 48 17 82 20 63 78 59 34 61 91 21 11 40 83 97 47 89 18 64 70 85 50
            Card 199: 74 30 60 87 46 21 69 51 28 96 | 92 64 32 66 65 54 29 85 84  2  6  3 97 37 22 33  1 23 38 88 75 99 17 12 31""";

    public static void main(String[] args) {
        int idx = 0;

        Map<Integer, Integer> mapWin = new HashMap<>();
        Map<Integer, Integer> mapCopy = new HashMap<>();
        for (String s : input.split("\n")) {
            s = s.substring(10);
            String winNums = s.split(" \\| ")[0].trim();
            String myNums = s.split(" \\| ")[1];
            Set<Integer> set = Arrays.stream(winNums.split(" ")).filter(StringUtils::isNotBlank).map(Integer::parseInt).collect(Collectors.toSet());
            String[] myNumArr = myNums.split(" ");
            int match = 0;
            for (String value : myNumArr) {
                if (value.isEmpty()) continue;
                if (set.contains(Integer.parseInt(value))) {
                    match += 1;
                }
            }
            mapWin.put(idx, match);
            mapCopy.put(idx, 1);
            idx = idx + 1;
        }
        for (int i = 0; i < mapWin.size(); i++) {
            int numWin = mapWin.get(i);
            System.out.println(i + ": " + numWin);
            int numCopy = mapCopy.get(i);
            if (numWin == 0) continue;
            for (int j = i + 1; j <= i + numWin; j++) {
                if (j >= mapWin.size()) break;
                mapCopy.put(j, mapCopy.get(j) + numCopy);
            }
        }
        System.out.println(mapCopy.values().stream().reduce(0, Integer::sum));
    }

}
