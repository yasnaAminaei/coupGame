package ManageGameStates.ProcessTheGame;

import Actions.Action;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Steal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.*;
import Actions.Logging;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import GUI.Controller.GameState.ChallengeOrAllow;
import GUI.Controller.GameState.ChooseCartToBurn;
import GUI.Controller.GameState.ChoosePlayer;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.IOException;
import java.net.ProxySelector;

public class ChoosePlayerToStealFromState extends Processor {


    Player chosenPlayer;

    public ChoosePlayerToStealFromState(Steal steal) throws IOException {
        this.mainActionRunning=steal;
        ChoosePlayer choosePlayer =new ChoosePlayer();
        this.chosenPlayer = choosePlayer.getChosenPlayer();
        ((Steal) mainActionRunning).setTarget(chosenPlayer);
        new Logging(steal);
        if (!AIRespondsChallengedOrBlockedItCorrectly()){
            //steal from chosen player
            mainActionRunning.doIfDone();
        }




    }


    public boolean AIRespondsChallengedOrBlockedItCorrectly() throws IOException {
        for (Player p : PlayersDataBase.AIPlayers()) {
            if (p.equals(chosenPlayer)){

                if (p instanceof AI){
                    BlockActionKinds blockActionKind =((AI) p).BlockOrAllow(mainActionRunning);

                    if (blockActionKind.equals(BlockActionKinds.nothing)){
                        if (challengeBtP(p)){
                            return true;
                        }
                    }
                    if (blockActionKind.equals(BlockActionKinds.Block_stealing_by_Ambassador)){
                        BlockStealingByAmbassador block_stealing = new BlockStealingByAmbassador(p ,mainActionRunning);
                        if (BlockByP(block_stealing)){
                            return true;
                        }

                    }
                    else {
                        BlockStealingByCaptain block_stealing=new BlockStealingByCaptain(p,mainActionRunning);
                        if (BlockByP(block_stealing)){
                            return true;
                        }
                    }

                }
            }
            else{
                if (challengeBtP(p)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean BlockByP(Block_stealing block_stealing ) throws IOException {

        if (block_stealing.isBlocked()){
            ChallengeOrAllow challengeOrAllow= new ChallengeOrAllow(block_stealing);
            if(challengeOrAllow.isChallengeResult()){
                //challenge was ok so blocking not gonna happen

            }
            else{
                //challenge was failed
                return true;

            }
        }
        return false;

    }


    public boolean challengeBtP(Player p ) throws IOException {
        Challenge c=new Challenge(p, (ChallengeAbleAction) mainActionRunning);
        if (c.isChallenged()){
            if (c.getChallengeResult()){
                mainActionRunning.stateOfAction= StateOfAction.failed;
                return true;
            }
        }
        return false;
    }




}
