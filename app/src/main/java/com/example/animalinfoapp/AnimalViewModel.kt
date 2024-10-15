// File: AnimalViewModel.kt

package com.example.animalinfoapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class AnimalInfo(
    val hebrewName: String,
    val hebrewInfo: String,
    val englishName: String,
    val englishInfo: String,
    val imageUrl: String,
    val englishcategory: String,
    val hebrewcategory: String,
    val userContributions: MutableList<String> = mutableListOf()
)

class AnimalViewModel : ViewModel() {
    var isEnglish by mutableStateOf(false)
        private set
    var searchQuery by mutableStateOf("")
        private set
    var selectedAnimal by mutableStateOf<AnimalInfo?>(null)
        private set
    var selectedCategory by mutableStateOf<String?>(null)
        private set

    private val animals = mutableListOf(
        // Mammals
        AnimalInfo(
            "אריה",
            "האריה הוא טורף גדול ממשפחת החתוליים, ידוע כמלך החיות.",
            "Lion",
            "The lion is a large predator from the cat family, known as the king of beasts.",
            "https://upload.wikimedia.org/wikipedia/commons/7/73/Lion_waiting_in_Namibia.jpg",
            "Mammals",
            "יונקים"
        ),
        AnimalInfo(
            "פיל",
            "הפיל הוא היונק היבשתי הגדול ביותר בעולם, ידוע בחוכמתו ובזיכרונו הטוב.",
            "Elephant",
            "The elephant is the largest land mammal in the world, known for its intelligence and good memory.",
            "https://upload.wikimedia.org/wikipedia/commons/3/37/African_Bush_Elephant.jpg",
            "Mammals",
            "יונקים"
        ),
        AnimalInfo(
            "ג'ירפה",
            "הג'ירפה היא בעל החיים היבשתי הגבוה ביותר, עם צוואר ארוך במיוחד.",
            "Giraffe",
            "The giraffe is the tallest land animal, with an exceptionally long neck.",
            "https://upload.wikimedia.org/wikipedia/commons/9/9e/Giraffe_Mikumi_National_Park.jpg",
            "Mammals",
            "יונקים"
        ),
        AnimalInfo(
            "זברה",
            "הזברה ידועה בפסים השחורים והלבנים שלה, המשמשים להסוואה מפני טורפים.",
            "Zebra",
            "The zebra is known for its black and white stripes, which serve as camouflage against predators.",
            "https://upload.wikimedia.org/wikipedia/commons/e/e3/Plains_Zebra_Equus_quagga.jpg",
            "Mammals",
            "יונקים"
        ),
        AnimalInfo(
            "קנגורו",
            "הקנגורו הוא יונק כיס אוסטרלי, ידוע ביכולתו לקפוץ למרחקים גדולים.",
            "Kangaroo",
            "The kangaroo is an Australian marsupial, known for its ability to jump long distances.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Kangaroo_Australia_01_11_2008_-_retouch.JPG/220px-Kangaroo_Australia_01_11_2008_-_retouch.JPG",
            "Mammals",
            "יונקים"
        ),
        AnimalInfo(
            "דולפין",
            "הדולפין הוא יונק ימי חכם וחברותי, ידוע ביכולת התקשורת המפותחת שלו.",
            "Dolphin",
            "The dolphin is an intelligent and social marine mammal, known for its advanced communication skills.",
            "https://upload.wikimedia.org/wikipedia/commons/1/10/Tursiops_truncatus_01.jpg",
            "Mammals",
            "יונקים"
        ),


        // Birds
        AnimalInfo(
            "תוכי",
            "התוכי הוא ציפור צבעונית ומדברת, ידועה ביכולתה לחקות קולות.",
            "Parrot",
            "The parrot is a colorful talking bird, known for its ability to mimic sounds.",
            "https://megapet.co.il/wp-content/uploads/2022/11/articles-53.jpg",
            "Birds",
            "ציפורים"
        ),
        AnimalInfo(
            "פינגווין",
            "הפינגווין הוא עוף ימי שאינו מסוגל לעוף, אך מצוין בשחייה.",
            "Penguin",
            "The penguin is a flightless seabird that excels in swimming.",
            "https://upload.wikimedia.org/wikipedia/commons/0/07/Emperor_Penguin_Manchot_empereur.jpg",
            "Birds",
            "ציפורים"
        ),
        AnimalInfo(
            "נשר",
            "הנשר הוא עוף דורס גדול בעל ראייה חדה במיוחד.",
            "Eagle",
            "The eagle is a large bird of prey with exceptionally sharp vision.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Gyps_fulvus_in_flight.jpg/375px-Gyps_fulvus_in_flight.jpg",
            "Birds",
            "ציפורים"
        ),
        AnimalInfo(
            "ינשוף",
            "הינשוף הוא עוף לילי בעל שמיעה מעולה ויכולת לסובב את ראשו כמעט 360 מעלות.",
            "Owl",
            "The owl is a nocturnal bird with excellent hearing and the ability to turn its head almost 360 degrees.",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTeapck5IIpCNbQ_iJ_6cyhTlnKUpoww9ZWTAxGSzLQMwPoh-BvThCZxDGyny12H20pBikzzC7XfP0hT50d-5E5Cg-Q4ueMm8QvfSTOKA",
            "Birds",
            "ציפורים"
        ),
        AnimalInfo(
            "טווס",
            "הטווס ידוע בזנבו המרהיב שהוא פורש בעת חיזור.",
            "Peacock",
            "The peacock is known for its spectacular tail, which it spreads during courtship.",
            "https://upload.wikimedia.org/wikipedia/commons/c/c5/Peacock_Plumage.jpg",
            "Birds",
            "ציפורים"
        ),
        AnimalInfo(
            "פלמינגו",
            "הפלמינגו הוא עוף ורוד ארוך רגליים הידוע בעמידתו על רגל אחת.",
            "Flamingo",
            "The flamingo is a pink, long-legged bird known for standing on one leg.",
            "https://upload.wikimedia.org/wikipedia/commons/b/b8/James_Flamingos_MC.jpg",
            "Birds",
            "ציפורים"
        ),


        // Fish
        AnimalInfo(
            "כריש",
            "הכריש הוא טורף ימי גדול, בעל חוש ריח מפותח במיוחד.",
            "Shark",
            "The shark is a large marine predator with a highly developed sense of smell.",
            "https://upload.wikimedia.org/wikipedia/commons/5/56/White_shark.jpg",
            "Fish",
            "דגים"
        ),
        AnimalInfo(
            "דג זהב",
            "דג הזהב הוא דג נוי פופולרי, ידוע בצבעו הזהוב ובזיכרונו הקצר.",
            "Goldfish",
            "The goldfish is a popular ornamental fish, known for its golden color and short memory.",
            "https://upload.wikimedia.org/wikipedia/commons/a/ae/Katri.jpg",
            "Fish",
            "דגים"
        ),

        AnimalInfo(
            "דג קופסה",
            "דג הקופסה הוא אחד הדגים הרעילים ביותר בעולם.",
            "Boxfish",
            "The boxfish is one of the most poisonous fish in the world.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Kofferfisch_%28Ostracion_cubicus%29_02.jpg/1280px-Kofferfisch_%28Ostracion_cubicus%29_02.jpg",
            "Fish",
            "דגים"
        ),
        AnimalInfo(
            "דג ליצן",
            "דג הליצן ידוע בצבעיו העזים ובסימביוזה שלו עם שושנות הים.",
            "Clownfish",
            "The clownfish is known for its bright colors and symbiosis with sea anemones.",
            "https://upload.wikimedia.org/wikipedia/commons/f/f6/Clown_fish_in_the_Andaman_Coral_Reef.jpg",
            "Fish",
            "דגים"
        ),
        AnimalInfo(
            "חרב-נון",
            "החרב-נון ידוע ב'חרב' הארוכה שלו, המשמשת לציד.",
            "Swordfish",
            "The swordfish is known for its long 'sword', used for hunting.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Xiphias_gladius_Linnaeus%2C_1758_2599925021.jpg/220px-Xiphias_gladius_Linnaeus%2C_1758_2599925021.jpg",
            "Fish",
            "דגים"
        ),
        AnimalInfo(
            "דג מנקה",
            "דג המנקה חי בסימביוזה עם דגים גדולים יותר, אוכל טפילים מגופם.",
            "Cleaner fish",
            "The cleaner fish lives in symbiosis with larger fish, eating parasites from their bodies.",
            "https://www.animalshop.co.il/images/itempics/uploads/media_18062020170127.jpg?rnd=.1992609?rnd=0.7244955161540214",
            "Fish",
            "דגים"
        ),


        // Reptiles
        AnimalInfo(
            "תנין",
            "התנין הוא זוחל טורף גדול החי במים מתוקים ומלוחים.",
            "Crocodile",
            "The crocodile is a large predatory reptile living in both fresh and salt water.",
            "https://upload.wikimedia.org/wikipedia/commons/b/bd/Nile_crocodile_head.jpg",
            "Reptiles",
            "זוחלים"
        ),
        AnimalInfo(
            "צב ים",
            "צב הים מבלה את רוב חייו בים, אך חוזר ליבשה להטיל ביצים.",
            "Sea turtle",
            "The sea turtle spends most of its life in the sea but returns to land to lay eggs.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Chelonia_Mydas.JPG/1200px-Chelonia_Mydas.JPG",
            "Reptiles",
            "זוחלים"
        ),
        AnimalInfo(
            "איגואנה",
            "האיגואנה היא לטאה גדולה הנפוצה באמריקה הטרופית.",
            "Iguana",
            "The iguana is a large lizard common in tropical America.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Green_Iguana_In_Florida.jpg/220px-Green_Iguana_In_Florida.jpg",
            "Reptiles",
            "זוחלים"
        ),
        AnimalInfo(
            "נחש צפע",
            "נחש הצפע הוא נחש ארסי בעל ראש משולש אופייני.",
            "Viper",
            "The viper is a venomous snake with a characteristic triangular head.",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRBlzId9rMFgOp9GP11RTCJv-CQHCINLCqQPxi152McfO4yvfex",
            "Reptiles",
            "זוחלים"
        ),
        AnimalInfo(
            "קמלאון",
            "הקמלאון ידוע ביכולתו לשנות צבעים ובעיניו הנעות באופן עצמאי.",
            "Chameleon",
            "The chameleon is known for its ability to change colors and its independently moving eyes.",
            "https://i.natgeofe.com/k/51d47b98-978b-4095-bd8e-7897126b9099/chameleon-sleepy_3x2.jpg",
            "Reptiles",
            "זוחלים"
        ),
        AnimalInfo(
            "גקו",
            "הגקו הוא לטאה קטנה בעלת יכולת להידבק לקירות ותקרות.",
            "Gecko",
            "The gecko is a small lizard with the ability to stick to walls and ceilings.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Phelsuma_l._laticauda.jpg/220px-Phelsuma_l._laticauda.jpg",
            "Reptiles",
            "זוחלים"
        ),

    )

    fun getFilteredAnimals(): List<AnimalInfo> {
        return animals.filter { animal ->
            val matchesCategory = selectedCategory == null ||
                    (if (isEnglish) animal.englishcategory else animal.hebrewcategory) == selectedCategory
            val matchesSearch = if (isEnglish) {
                animal.englishName.contains(searchQuery, ignoreCase = true)
            } else {
                animal.hebrewName.contains(searchQuery, ignoreCase = true)
            }
            matchesCategory && matchesSearch
        }
    }

    fun getCategories(): List<String> {
        return animals.map { if (isEnglish) it.englishcategory else it.hebrewcategory }.distinct()
    }

    fun toggleLanguage() {
        isEnglish = !isEnglish
    }

    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    fun selectAnimal(animal: AnimalInfo) {
        selectedAnimal = animal
    }

    fun selectCategory(category: String?) {
        selectedCategory = category
    }

    fun addContribution(animalName: String, contribution: String) {
        animals.find { it.englishName == animalName || it.hebrewName == animalName }?.let {
            it.userContributions.add(contribution)
        }
    }
}