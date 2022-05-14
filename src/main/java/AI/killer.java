package AI;

import Cards.Card;
import Cards.Duke;
import Players.Player;
import Players.PlayersDataBase;

import java.util.ArrayList;

public class killer {

    /**
     * قاتل محتاط: این بازیکن به دنبال حمله کردن است اما حاضر به بلوف زدن نیست. در صورتی
     * که کارت قاتل نداشته باشد استراتژی بازی او به این صورت است: اگر سفیر داشته باشد در هر نوبت خود تصمیم به تعویض کردن کارت می‌گیرد و
     * اگر در کارت‌هایی که از دسته کارت‌ها می آید قاتل پیدا کند آن‌ را با سفیر عوض می‌کند و در غیر اینصورت تعویض نمی‌کند. در صورت نداشتن
     * سفیر نیز در نوبت خود اگر یک سکه داشته باشد تقاضای تعویض می‌کند و اگر سکه نداشته باشد اقدام به دریافت دو سکه می‌کند.
     */




    public String id;



    public killer(){
         Player player= PlayersDataBase.searchByPlayerId(id);
         assert player != null;
         //ArrayList<Card> playersCard = player.getCards();
    }





}
